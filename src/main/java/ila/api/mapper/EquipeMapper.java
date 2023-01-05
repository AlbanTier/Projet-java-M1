package ila.api.mapper;

import ila.api.dto.EquipeCreateDto;
import ila.api.dto.EquipeDto;
import ila.project.tournament_manager.model.Equipe;
import ila.project.tournament_manager.model.Joueur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipeMapper {

    EquipeDto mapToDto(Equipe equipe);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tournois", ignore = true)
    Equipe mapToEntity(EquipeCreateDto equipeCreateDto, List<Joueur> joueurs);

}
e