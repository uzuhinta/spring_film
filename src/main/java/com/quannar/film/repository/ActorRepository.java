package com.quannar.film.repository;

import com.quannar.film.model.Actor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query(
            "SELECT a FROM Actor a"
    )
    List<Actor> getAllActor();

    @Query(
            "SELECT a FROM Actor a WHERE a.id = :userId"
    )
    Optional<Actor> getActorById(@Param("userId") Long userId);

    @Query(
            "SELECT a FROM Actor a"
    )
    Page<Actor> getActorWithPagination(Pageable pageable);

    @Modifying
    @Query(
            value = "DELETE FROM actor a WHERE a.id = ?1",
            nativeQuery = true
    )
    void deleteActorById(Long userId);

}