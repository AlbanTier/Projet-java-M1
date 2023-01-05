package ila.api;

import ila.api.dto.TournoiCreateDto;
import ila.api.exception.IdMismatchException;
import ila.project.tournament_manager.model.Tournoi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import ila.api.dto.TournoiDto;
import ila.api.exception.ResourceNotFoundException;
import ila.api.mapper.TournoiMapper;
import ila.project.tournament_manager.service.TournoiService;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/tournoi", produces = APPLICATION_JSON_VALUE)
public class TournoiController {
    private final TournoiService tournoiService;
    private final TournoiMapper mapper;

    @GetMapping(path = "/{id}")
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<TournoiDto> getTournoiById(
            @PathVariable(name = "id") Long tournoiId
    ) {
        return tournoiService.getTournoiById(tournoiId)
                .map(mapper::mapToDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Tournoi", tournoiId));
    }

    /*@PostMapping
    public ResponseEntity<TournoiDto> createTournoi(
            @RequestBody TournoiCreateDto TournoiCreateDto
    ) {
        Tournoi Tournoi = mapper.mapToEntity(TournoiCreateDto);
        Tournoi createdTournoi = TournoiService.saveTournoi(Tournoi);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDto(createdTournoi));
    }*/

   /* @PutMapping(path = "/{id}")
    public ResponseEntity<TournoiDto> updateTournoi(
            @PathVariable Long id,
            @RequestBody TournoiDto TournoiDto
    ) {
        Optional<Tournoi> optionalTournoi = TournoiService.getTournoiById(id);
        if (optionalTournoi.isEmpty()) {
            throw new ResourceNotFoundException("Tournoi", id);
        }

        if (!Objects.equals(id, TournoiDto.getId())) {
            throw new IdMismatchException(id, TournoiDto.getId());
        }

        Tournoi Tournoi = optionalTournoi.get();
        Tournoi.setName(TournoiDto.getName());
        Tournoi.setDescription(TournoiDto.getDescription());

        Tournoi updatedTournoi = TournoiService.saveTournoi(Tournoi);
        return ResponseEntity.ok(mapper.mapToDto(updatedTournoi));
    }*/

  /*  @GetMapping(path = "/{id}")
    public ResponseEntity<TournoiDto> getTournoiById(
            @PathVariable(name = "id") Long TournoiId
    ) {
        return TournoiService.getTournoiById(TournoiId)
                .map(mapper::mapToDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Tournoi", TournoiId));
    }*/
    
}