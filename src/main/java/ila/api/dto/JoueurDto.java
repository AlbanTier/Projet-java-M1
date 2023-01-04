package ila.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JoueurDto {
    private Long id;
    private String pseudo;
    private String adresse;
    private List<EquipeDto> equipes;
}
