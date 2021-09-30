package com.quannar.film.service;

import com.quannar.film.payload.request.ActorDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;

public interface TypeService {

    void getAll(ResponseBean bean);

    void create(ResponseBean bean, TypeDTO typeDTO);

    void deleteTypeById(ResponseBean bean, Long actorId);

}
