package com.quannar.film.service;

import com.quannar.film.payload.request.ActorDTO;
import com.quannar.film.payload.response.ResponseBean;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface ActorService {

   void getActors(ResponseBean bean);
   void getActor(ResponseBean bean, Long actorId);
   void getActorWithPagination(ResponseBean bean, Integer page, Integer size);
   void create(ResponseBean bean, ActorDTO actorDTO);
   void deleteActorById(ResponseBean bean, Long actorId);
   void updateActor(ResponseBean bean, Long actorId, ActorDTO actorDTO);

}