package com.ducpham.project_01.model.dto.search;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductSearch extends BaseSearch {
    private String text;
    private String price;
}
