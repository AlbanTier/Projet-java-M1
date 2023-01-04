package ila.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EquipeCreateDto {

    private String nom;

    private List<JoueurDto> joueurs;

    private List<TournoiDto> tournois;
}
