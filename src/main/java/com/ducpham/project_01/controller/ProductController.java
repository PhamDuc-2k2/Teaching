package com.ducpham.project_01.controller;

import com.ducpham.project_01.model.dto.ProductDTO;
import com.ducpham.project_01.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productDTO));
    }

    @GetMapping("/get-product-dto/{code}")
    public ResponseEntity<?> getProductDTOByCode(@PathVariable  String code) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductDTOByCode(code));
    }
}
