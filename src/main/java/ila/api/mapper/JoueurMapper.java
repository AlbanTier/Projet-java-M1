package ila.api.mapper;

import ila.api.dto.JoueurCreateDto;
import ila.api.dto.JoueurDto;
import ila.project.tournament_manager.model.Joueur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JoueurMapper {

    JoueurDto mapToDto(Joueur joueur);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "equipes", ignore = true)
    Joueur mapToEntity(JoueurCreateDto joueurCreateDto);

}
