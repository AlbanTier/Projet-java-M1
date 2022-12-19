package ila.api.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ila.api.dto.PaginationContext;

@Mapper(componentModel = "spring")
public interface PageMapper {
    @Mapping(target = "page", source = "number")
    @Mapping(target = "count", source = "numberOfElements")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "total", source = "totalElements")
    PaginationContext toPaginationContext(Page<?> page);
}