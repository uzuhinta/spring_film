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

   void getActors(ResponseBean bean) throws Exception;
   void getActor(ResponseBean bean, Long actorId) throws Exception;
   void getActorWithPagination(ResponseBean bean, Integer page, Integer size) throws Exception;
   void create(ResponseBean bean, ActorDTO actorDTO) throws Exception;
   void deleteActorById(ResponseBean bean, Long actorId) throws Exception;
   void updateActor(ResponseBean bean, Long actorId, ActorDTO actorDTO) throws Exception;

}