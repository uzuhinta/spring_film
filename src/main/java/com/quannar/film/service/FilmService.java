package com.quannar.film.service;

import com.quannar.film.payload.request.FilmDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;

public interface FilmService {

    void getAll(ResponseBean bean);

    void create(ResponseBean bean, FilmDTO filmDTO);

    void deleteFilmById(ResponseBean bean, Long filmId);

}
