package com.project.mobilki.repository;


import com.project.mobilki.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("Select p FROM Product p WHERE p.productName = ?1")
    List<Product> searchFor(String productName);

    @Query("Select p FROM Product p WHERE p.barcode = ?1")
    Product searchForId(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.barcode = :id")
    void deleteId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p")
    void deleteAll();

}