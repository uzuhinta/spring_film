package com.quannar.film.repository;

import com.quannar.film.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(
            "SELECT c FROM Category c"
    )
    List<Category> getAllCategory();

    @Query(
            "SELECT c FROM Category c WHERE c.id = :categoryId"
    )
    Optional<Category> getCategoryById(@Param("categoryId") Long categoryId);

    @Modifying
    @Query(
            "DELETE FROM Category c WHERE c.id = :categoryId "
    )
    void deleteCategoryById(@Param("categoryId") Long categoryId);
}
