package ila.api.dto;

import java.sql.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TournoiCreateDto {
    
    private Date date;
    private String type;
    private String description;
    private List<EtatDto> etats;
    private List<EquipeDto> equipes;
}
