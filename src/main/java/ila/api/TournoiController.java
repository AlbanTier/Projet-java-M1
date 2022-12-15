package ila.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ila.api.mapper.TournoiMapper;
import ila.service.TournoiService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/tournoi", produces = APPLICATION_JSON_VALUE)
public class TournoiController {
    private final TournoiService superheroService;

    private final TournoiMapper mapper;
    
}