package ila.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JoueurCreateDto {

    private String pseudo;
    private String adresse;
    private List<EquipeDto> equipes;
}
