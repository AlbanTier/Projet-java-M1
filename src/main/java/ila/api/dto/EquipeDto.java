package ila.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EquipeDto {
    private Long id;

    private String name;

    private List<JoueurDto> joueurs;

    private List<TournoiDto> tournois;
}
