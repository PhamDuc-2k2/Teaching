package com.ducpham.project_01.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse {
    private int pageNp;
    private int pageSize;
    private long totalElements;
    private long totalPages;
    private Object contents;
}
