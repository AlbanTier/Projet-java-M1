package ila.api;

import ila.api.dto.*;
import ila.api.exception.IdMismatchException;
import ila.api.exception.ResourceNotFoundException;
import ila.api.mapper.EquipeMapper;
import ila.api.mapper.PageMapper;
import ila.project.tournament_manager.model.Equipe;
import ila.project.tournament_manager.model.Tournoi;
import ila.project.tournament_manager.service.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "v1/equipes", produces = APPLICATION_JSON_VALUE)
public class EquipeController {
    private final EquipeService equipeService;
    private final EquipeMapper mapper;

    @GetMapping
    public ResponseEntity<PageDto<EquipeDto>> getEquipes(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize
    ) {
        return ResponseEntity.ok(
                mapper.mapToPageDto(equipeService.getAllEquipes(name, PageRequest.of(page, pageSize)))
        );

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EquipeDto> getEquipeById(
            @PathVariable(name = "id") Long equipeId
    ) {
        return equipeService.getEquipeById(equipeId)
                .map(mapper::mapToDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Equipe", equipeId));
    }

    @PostMapping
    public ResponseEntity<EquipeDto> createEquipe(
            @RequestBody EquipeCreateDto equipeCreateDto
    ) {
        Equipe equipe = mapper.mapToEntity(equipeCreateDto);
        Equipe createdEquipe = equipeService.saveEquipe(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDto(createdEquipe));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EquipeDto> updateEquipe(
            @PathVariable Long id,
            @RequestBody EquipeDto equipeDto
    ) {
        Optional<Equipe> optionalEquipe = equipeService.getEquipeById(id);
        if (optionalEquipe.isEmpty()) {
            throw new ResourceNotFoundException("Equipe", id);
        }

        if (!Objects.equals(id, equipeDto.getId())) {
            throw new IdMismatchException(id, equipeDto.getId());
        }

        Equipe equipe = optionalEquipe.get();
        equipe.setName(equipeDto.getName());

        Equipe updatedEquipe = equipeService.saveEquipe(equipe);
        return ResponseEntity.ok(mapper.mapToDto(updatedEquipe));
    }
}

