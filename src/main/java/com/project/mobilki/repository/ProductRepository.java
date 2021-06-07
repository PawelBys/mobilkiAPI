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

    @Query("Select p FROM Product p WHERE p.id = ?1")
    Product searchForId(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.id = :id")
    void deleteId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p")
    void deleteAll();

//    @Transactional
//    @Modifying
//    @Query("UPDATE Product p SET p.productName = :pN, p.description = :des, p.rating = :rate, p.img = :im WHERE p.id = :id")
//    void updateProduct(@Param("id") long id, @Param("pN") String productName, @Param("des") String description, @Param("rate") float rating, @Param("im") String img);

}