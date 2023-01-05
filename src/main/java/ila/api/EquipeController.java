package ila.api;

import ila.project.tournament_manager.service.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "v1/equipes", produces = APPLICATION_JSON_VALUE)
public class EquipeController {
    private final EquipeService equipeService;
}
