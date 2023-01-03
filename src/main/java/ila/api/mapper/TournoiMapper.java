package ila.api.mapper;



import ila.api.dto.TournoiCreateDto;
import ila.api.dto.TournoiDto;
import ila.api.dto.PageDto;
import ila.project.tournament_manager.model.Tournoi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

//@Mapper(componentModel = "spring", uses = {EquipeMapper.class, PageMapper.class})
@Mapper(componentModel = "spring", uses = {PageMapper.class, PageMapper.class})
public interface TournoiMapper {
    Tournoi mapToEntity(TournoiCreateDto TournoiCreateDto);
    TournoiDto mapToDto(Tournoi Tournoi);

    @Mapping(target = "data", source = "content")
    @Mapping(target = "context", source = ".")
    PageDto<TournoiDto> mapToPageDto(Page<Tournoi> page);
}
