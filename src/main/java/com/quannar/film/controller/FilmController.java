package com.quannar.film.controller;

import com.quannar.film.payload.request.CategoryDTO;
import com.quannar.film.payload.request.FilmDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.FilmRepository;
import com.quannar.film.service.CategoryService;
import com.quannar.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/api")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(path = "/film")
    ResponseEntity getAllFilm() {
        ResponseBean bean = new ResponseBean();
        filmService.getAll(bean);
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/film")
    ResponseEntity createFilm(@RequestBody FilmDTO filmDTO) {
        ResponseBean bean = new ResponseBean();
        filmService.create(bean, filmDTO);
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping(path = "/secure/film/{id}")
    ResponseEntity deleteFilm(@PathVariable("id") Long typeId) {
        ResponseBean bean = new ResponseBean();
        filmService.deleteFilmById(bean, typeId);
        return ResponseEntity.ok(bean);
    }
}
