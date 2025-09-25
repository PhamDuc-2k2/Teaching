package com.ducpham.project_01.service.impl;

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

}
