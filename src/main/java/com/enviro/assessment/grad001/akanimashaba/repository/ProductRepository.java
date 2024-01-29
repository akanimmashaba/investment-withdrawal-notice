package com.enviro.assessment.grad001.akanimashaba.repository;

import com.enviro.assessment.grad001.akanimashaba.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
