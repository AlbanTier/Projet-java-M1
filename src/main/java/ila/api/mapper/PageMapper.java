package ila.api.mapper;

import ila.api.dto.PageDto;
import ila.api.dto.TournoiDto;
import ila.project.tournament_manager.model.Tournoi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ila.api.dto.PaginationContext;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface PageMapper {

    @Mapping(target = "page", source = "number")
    @Mapping(target = "count", source = "numberOfElements")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "total", source = "totalElements")
    PaginationContext toPaginationContext(Page<?> page);

    @Mapping(target = "data", source = "content")
    @Mapping(target = "context", source = ".")
    PageDto<TournoiDto> mapToPageDto(Page<Tournoi> page);
}
