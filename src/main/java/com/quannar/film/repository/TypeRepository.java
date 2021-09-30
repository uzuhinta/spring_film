package com.quannar.film.repository;

import com.quannar.film.model.Actor;
import com.quannar.film.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query(
            "SELECT t FROM Type t"
    )
    List<Type> getAllType();

    @Query(
            "SELECT a FROM Type a WHERE a.id = :typeId"
    )
    Optional<Type> getActorById(@Param("typeId") Long typeId);


    @Modifying
    @Query(
            value = "DELETE FROM type t WHERE t.id = ?1",
            nativeQuery = true
    )
    void deleteTypeById(Long typeId);

}
