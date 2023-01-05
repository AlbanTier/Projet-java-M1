package ila.api.mapper;

import ila.api.dto.EquipeCreateDto;
import ila.api.dto.EquipeDto;
import ila.api.dto.PageDto;
import ila.api.dto.TournoiDto;
import ila.project.tournament_manager.model.Equipe;
import ila.project.tournament_manager.model.Joueur;
import ila.project.tournament_manager.model.Tournoi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipeMapper {

    EquipeDto mapToDto(Equipe equipe);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tournois", ignore = true)
    Equipe mapToEntity(EquipeCreateDto equipeCreateDto, List<Joueur> joueurs);

    PageDto<EquipeDto> mapToPageDto(Page<Equipe> page);
    @Mapping(target = "data", source = "content")
    @Mapping(target = "context", source = ".")
    PageDto<TournoiDto> mapToPageDto(Page<Tournoi> page);

}