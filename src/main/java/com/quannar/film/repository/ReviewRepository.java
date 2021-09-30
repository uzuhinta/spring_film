package com.quannar.film.repository;

import com.quannar.film.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(
            "SELECT r FROM Review r"
    )
    List<Review> getAll();

    @Query(
            "SELECT r FROM Review r WHERE r.id = :reviewId"
    )
    Optional<Review> getReviewById(@Param("reviewId") Long reviewId);

    @Modifying
    @Query(
            "DELETE FROM Review r WHERE r.id = :reviewId"
    )
    void deleteReviewById(@Param("reviewId") Long reviewId);
}
