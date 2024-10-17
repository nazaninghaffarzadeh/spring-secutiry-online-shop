package com.nazanin.ecom.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nazanin.ecom.proj.model.Product;

@Repository
public interface ProductRepo  extends JpaRepository<Product,Integer>{

   @Query(nativeQuery = true, value = "SELECT * FROM products WHERE name LIKE %:keyword% OR description LIKE %:keyword%")
List<Product> searchProducts(@Param("keyword") String keyword);

    
}
