package com.quannar.film.controller;

import com.quannar.film.common.Constant;
import com.quannar.film.payload.request.CategoryDTO;
import com.quannar.film.payload.request.FilmDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.FilmRepository;
import com.quannar.film.service.CategoryService;
import com.quannar.film.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/api")
public class FilmController {

    private final FilmService filmService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(path = "/film")
    ResponseEntity getAllFilm() {
        ResponseBean bean = new ResponseBean();
        try {
            filmService.getAll(bean);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/film")
    ResponseEntity createFilm(@RequestBody FilmDTO filmDTO) {
        ResponseBean bean = new ResponseBean();
        try {
            filmService.create(bean, filmDTO);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping(path = "/secure/film/{id}")
    ResponseEntity deleteFilm(@PathVariable("id") Long typeId) {
        ResponseBean bean = new ResponseBean();
        try {
            filmService.deleteFilmById(bean, typeId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }
}
