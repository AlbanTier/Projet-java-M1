package ila.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtatDto {
    private Long id;

    private String nom;

}
