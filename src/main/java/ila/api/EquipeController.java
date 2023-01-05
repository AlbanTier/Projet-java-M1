package ila.api;

import ila.api.dto.EquipeDto;
import ila.api.dto.PageDto;
import ila.api.mapper.EquipeMapper;
import ila.api.mapper.PageMapper;
import ila.project.tournament_manager.service.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "v1/equipes", produces = APPLICATION_JSON_VALUE)
public class EquipeController {
    private final EquipeService equipeService;
    private final EquipeMapper equipeMapper;
    @GetMapping
    public ResponseEntity<PageDto<EquipeDto>>getEquipes(
        @RequestParam(required = false) String name,
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "5") int pageSize
    ){
        return ResponseEntity.ok(
            equipeMapper.mapToPageDto(equipeService.getAllEquipes(name, PageRequest.of(page, pageSize)))
        );

    }
}

