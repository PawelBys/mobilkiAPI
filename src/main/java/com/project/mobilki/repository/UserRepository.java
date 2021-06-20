package com.project.mobilki.repository;

import com.project.mobilki.entity.Product;
import com.project.mobilki.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("Select p FROM User p WHERE p.email = ?1 AND p.password = ?2")
    List<User> searchFor(String email, String password);

    @Query("Select p FROM User p WHERE p.id = ?1")
    User searchForId(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM User p WHERE p.id = :id")
    void deleteId(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM User p")
    void deleteAll();

}
