package ila.project.tournament_manager.controller;

import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import ila.api.dto.TournoiDto;
import ila.api.exception.ResourceNotFoundException;
import ila.api.mapper.TournoiMapper;
import ila.project.tournament_manager.service.TournoiService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/tournoi", produces = APPLICATION_JSON_VALUE)
public class TournoiController {
    private final TournoiService tournoiService;
    private final TournoiMapper mapper;

    @GetMapping(path = "/{id}")
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<TournoiDto> getSuperheroById(
            @PathVariable(name = "id") Long tournoiId
    ) {
        return tournoiService.getTournoiById(tournoiId)
                .map(mapper::mapToDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Tournoi", tournoiId));
    }
    
}