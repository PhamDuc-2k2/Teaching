package com.ducpham.project_01.model.dto.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseSearch {
    @Builder.Default
    private int pageNo = 1;
    @Builder.Default
    private int pageSize = 5;
    @Builder.Default
    private String sortBy = "id";
    @Builder.Default
    private String sortOrder = "asc";
}
