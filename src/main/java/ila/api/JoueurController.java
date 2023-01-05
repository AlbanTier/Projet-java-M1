package ila.api;

import ila.api.dto.JoueurCreateDto;
import ila.api.dto.JoueurDto;
import ila.api.dto.PageDto;
import ila.api.exception.IdMismatchException;
import ila.api.exception.ResourceNotFoundException;
import ila.api.mapper.JoueurMapper;
import ila.project.tournament_manager.model.Joueur;
import ila.project.tournament_manager.service.JoueurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/joueur", produces = APPLICATION_JSON_VALUE)
public class JoueurController {
    private final JoueurService joueurService;
    private final JoueurMapper mapper;

    @GetMapping
    public ResponseEntity<PageDto<JoueurDto>> getJoueurs(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize
    ) {
        return ResponseEntity.ok(
                mapper.mapToPageDto(joueurService.getAllJoueurs(name, PageRequest.of(page, pageSize)))
        );
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<JoueurDto> getJoueurById(
            @PathVariable(name="id") Long joueurid
    ) {
        return joueurService.getJoueurById(joueurid)
                .map(mapper::mapToDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Joueur", joueurid));
    }
    @PostMapping
    public ResponseEntity<JoueurDto> createJoueur(
            @RequestBody JoueurCreateDto joueurCreateDto
    ) {
        Joueur joueur = mapper.mapToEntity(joueurCreateDto);
        Joueur createdJoueur = joueurService.saveJoueur(joueur);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDto(createdJoueur));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<JoueurDto> updateJoueur(
            @PathVariable Long id,
            @RequestBody JoueurDto joueurDto
    ) {
        Optional<Joueur> optionalJoueur = joueurService.getJoueurById(id);
        if (optionalJoueur.isEmpty()) {
            throw new ResourceNotFoundException("Joueur", id);
        }

        if (!Objects.equals(id, joueurDto.getId())) {
            throw new IdMismatchException(id, joueurDto.getId());
        }
        Joueur joueur = optionalJoueur.get();
        joueur.setPseudo(joueurDto.getPseudo());
        joueur.setAdresse(joueurDto.getAdresse());

        Joueur updatedJoueur = joueurService.saveJoueur(joueur);
        return ResponseEntity.ok(mapper.mapToDto(updatedJoueur));
    }

}
