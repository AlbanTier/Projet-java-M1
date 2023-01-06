package ila.api.mapper;

import ila.api.dto.*;
import ila.project.tournament_manager.model.Equipe;
import ila.project.tournament_manager.model.Joueur;
import ila.project.tournament_manager.model.Tournoi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = {PageMapper.class})
public interface JoueurMapper {

    JoueurDto mapToDto(Joueur joueur);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "equipes", ignore = true)
    Joueur mapToEntity(JoueurCreateDto joueurCreateDto);

    @Mapping(target = "data", source = "content")
    @Mapping(target = "context", source = ".")
    PageDto<JoueurDto> mapToPageDto(Page<Joueur> page);
}
