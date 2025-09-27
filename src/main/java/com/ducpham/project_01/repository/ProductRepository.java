package com.ducpham.project_01.repository;

import com.ducpham.project_01.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByCodeOrName(String code, String name);
    Optional<Product> findByCode(String code);
}

