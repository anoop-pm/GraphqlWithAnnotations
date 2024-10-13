package com.example.SpringGQLMysql.repository;

import com.example.SpringGQLMysql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
