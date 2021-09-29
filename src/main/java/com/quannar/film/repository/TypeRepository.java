package com.quannar.film.repository;

import com.quannar.film.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query(
            "SELECT t FROM Type t"
    )
    List<Type> getAllType();

}
