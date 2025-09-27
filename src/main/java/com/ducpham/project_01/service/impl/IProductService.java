package com.ducpham.project_01.service.impl;

import com.ducpham.project_01.model.dto.ProductDTO;
import com.ducpham.project_01.model.dto.response.PageResponse;
import com.ducpham.project_01.model.dto.search.ProductSearch;
import com.ducpham.project_01.model.entity.Product;
import com.ducpham.project_01.repository.ProductRepository;
import com.ducpham.project_01.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IProductService implements ProductService {
    ProductRepository productRepository;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        if (productRepository.existsByCodeOrName(productDTO.getCode(), productDTO.getName())) {
            throw new RuntimeException("Product with code " + productDTO.getCode() + " already exists");
        }
        Product product = Product.builder()
                .code(productDTO.getCode())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();
        productRepository.saveAndFlush(product);
        return productDTO;
    }

    @Override
    public ProductDTO getById(String code) {
        return null;
    }

    @Override
    public PageResponse getAll(ProductSearch search) {
        return null;
    }

    @Override
    public ProductDTO update(String code, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO delete(String code) {
        return null;
    }
}
