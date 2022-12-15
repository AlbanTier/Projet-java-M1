package ila.api.mapper;

import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface PageMapper {

    @Mapping(target = "page", source = "number")
    @Mapping(target = "count", source = "numberOfElements")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "total", source = "totalElements")
    PaginationContext toPaginationContext(Page<?> page);
}
