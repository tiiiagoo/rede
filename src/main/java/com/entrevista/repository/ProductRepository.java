package com.entrevista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrevista.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
