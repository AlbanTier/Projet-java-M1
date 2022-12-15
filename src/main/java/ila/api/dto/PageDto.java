package ila.api.dto;


import java.util.List;

import lombok.Data;

@Data
public class PageDto<T> {
    private List<T> data;
    private PaginationContext context;
}
