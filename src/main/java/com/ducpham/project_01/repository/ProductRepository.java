package com.ducpham.project_01.repository;

import com.ducpham.project_01.model.dto.ProductDTO;
import com.ducpham.project_01.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    boolean existsByCodeOrName(String code, String name);
    Optional<Product> findByCode(String code);

    @Query("select p from Product p where p.name like :name ")
    Set<Product> getProductByName(String name);

    @Query("select new com.ducpham.project_01.model.dto.ProductDTO(p.code, p.name, p.quantity, p.price) from Product p where p.code = :code")
    Optional<ProductDTO> findProductDTOByCode(String code);

}

