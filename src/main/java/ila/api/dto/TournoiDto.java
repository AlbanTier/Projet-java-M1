package ila.api.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TournoiDto {
    private Long id;
    private Date date;
    private String type;
    private String description;
    private String etat;
    private int nbParticipants;
}
