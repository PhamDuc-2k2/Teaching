package com.ducpham.project_01.utils.specification;

import com.ducpham.project_01.model.dto.search.ProductSearch;
import com.ducpham.project_01.model.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpec {
    public static Specification<Product> searchProduct(ProductSearch search) {
       return (root, query, criteriaBuilder) -> {
           Predicate predicate = criteriaBuilder.greaterThan(root.get("price"), search.getPrice());
           return predicate;
       };
    }
}
