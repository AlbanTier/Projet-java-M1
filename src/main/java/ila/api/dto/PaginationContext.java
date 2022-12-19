package ila.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationContext {
    private Integer page;
    private Integer pageSize;
    private Integer count;
    private Long total;
}
