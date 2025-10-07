package com.ducpham.project_01.service;

import com.ducpham.project_01.model.dto.ProductDTO;
import com.ducpham.project_01.model.dto.response.PageResponse;
import com.ducpham.project_01.model.dto.search.ProductSearch;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);
    ProductDTO getByCode(String code);
    PageResponse getAll(ProductSearch search);
    ProductDTO update(String code, ProductDTO productDTO);
    void delete(String code);

    ProductDTO getProductDTOByCode(String code);
}
