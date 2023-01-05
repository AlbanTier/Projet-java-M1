package ila.api;

import ila.api.dto.PageDto;
import ila.api.dto.TournoiCreateDto;
import ila.api.exception.IdMismatchException;
import ila.project.tournament_manager.model.Tournoi;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping
    public ResponseEntity<PageDto<TournoiDto>> getTournois(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize
    ) {
        return ResponseEntity.ok(
                mapper.mapToPageDto(tournoiService.getAllTournois(name, PageRequest.of(page, pageSize)))
        );
    }

    @PostMapping
    public ResponseEntity<TournoiDto> createTournoi(
            @RequestBody TournoiCreateDto tournoiCreateDto
    ) {
        Tournoi tournoi = mapper.mapToEntity(tournoiCreateDto);
        Tournoi createdTournoi = tournoiService.saveTournoi(tournoi);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDto(createdTournoi));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TournoiDto> updateTournoi(
            @PathVariable Long id,
            @RequestBody TournoiDto tournoiDto
    ) {
        Optional<Tournoi> optionalTournoi = tournoiService.getTournoiById(id);
        if (optionalTournoi.isEmpty()) {
            throw new ResourceNotFoundException("Tournoi", id);
        }

        if (!Objects.equals(id, tournoiDto.getId())) {
            throw new IdMismatchException(id, tournoiDto.getId());
        }

        Tournoi tournoi = optionalTournoi.get();
        tournoi.setName(tournoiDto.getName());
        tournoi.setDescription(tournoi.getDescription());
        tournoi.setType(tournoi.getType());

        Tournoi updatedTournoi = tournoiService.saveTournoi(tournoi);
        return ResponseEntity.ok(mapper.mapToDto(updatedTournoi));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TournoiDto> getTournoiById(
            @PathVariable(name = "id") Long tournoiId
    ) {
        return tournoiService.getTournoiById(tournoiId)
                .map(mapper::mapToDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Tournoi", tournoiId));
    }
}