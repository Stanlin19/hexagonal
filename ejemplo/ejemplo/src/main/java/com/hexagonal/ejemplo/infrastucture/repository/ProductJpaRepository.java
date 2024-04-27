package com.hexagonal.ejemplo.infrastucture.repository;

import com.hexagonal.ejemplo.infrastucture.models.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

}
