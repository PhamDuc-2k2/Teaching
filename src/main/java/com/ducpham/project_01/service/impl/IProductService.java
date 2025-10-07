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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ProductDTO getByCode(String code) {
        Product product = getProductByCode(code);
        return ProductDTO.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public PageResponse getAll(ProductSearch search) {
        Pageable pageable = PageRequest.of(0, 1);
        return null;
    }

    @Transactional
    @Override
    public ProductDTO update(String code, ProductDTO productDTO) {
        Product product = getProductByCode(code);

        product.setCode(productDTO.getCode());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        productRepository.saveAndFlush(product);

        return productDTO;
    }

    @Transactional
    @Override
    public void delete(String code) {
        Product product = getProductByCode(code);
        productRepository.delete(product);
    }

    @Override
    public ProductDTO getProductDTOByCode(String code) {
        return productRepository.findProductDTOByCode(code).orElse(null);
    }

    private Product getProductByCode(String code) {
        return productRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Product with code " + code + " not found"));
    }
}
