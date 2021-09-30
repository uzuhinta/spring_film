package com.quannar.film.service;

import com.quannar.film.payload.request.FilmDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;

public interface FilmService {

    void getAll(ResponseBean bean) throws Exception;

    void create(ResponseBean bean, FilmDTO filmDTO) throws Exception;

    void deleteFilmById(ResponseBean bean, Long filmId) throws Exception;

}
