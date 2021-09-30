package com.quannar.film.repository;

import com.quannar.film.model.Film;
import com.quannar.film.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query(
            "SELECT f FROM Film f"
    )
    List<Film> getAllFilm();

    @Query(
            "SELECT f FROM Film f WHERE f.id = :filmId"
    )
    Optional<Film> getFilmById(@Param("filmId") Long filmId);


    @Modifying
    @Query(
            value = "DELETE FROM film t WHERE t.id = ?1",
            nativeQuery = true
    )
    void deleteTypeById(Long filmId);

}
