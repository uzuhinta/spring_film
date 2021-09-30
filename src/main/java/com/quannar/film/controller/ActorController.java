package com.quannar.film.controller;

import com.quannar.film.common.Constant;
import com.quannar.film.payload.request.ActorDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;


@RestController
@RequestMapping(path = "/api")
public class ActorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActorController.class);

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping(path = "/actor")
    ResponseEntity getActors() {
        ResponseBean bean = new ResponseBean();
        try {
            actorService.getActors(bean);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @GetMapping(path = "/actor/{id}")
    ResponseEntity getActor(@PathVariable("id") Long actorId) {
        ResponseBean bean = new ResponseBean();
        try {
            actorService.getActor(bean, actorId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @GetMapping(path = "/actors-with-pagination")
    ResponseEntity getActorWithPagination(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ) {
        ResponseBean bean = new ResponseBean();
        try {
            actorService.getActorWithPagination(bean, page, size);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @PostMapping(value = "/secure/actor", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity createActor(@Valid @ModelAttribute ActorDTO actorDTO) {
        ResponseBean bean = new ResponseBean();

        try {
            LOGGER.info(actorDTO.toString());
            actorService.create(bean, actorDTO);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping(path = "/secure/actor/{id}")
    ResponseEntity deleteActor(@PathVariable("id") Long actorId) {
        ResponseBean bean = new ResponseBean();
        try {
            actorService.deleteActorById(bean, actorId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/actor/{id}")
    ResponseEntity updateActor(
            @PathVariable("id") Long actorId,
            @ModelAttribute ActorDTO actorDTO
    ) {
        ResponseBean bean = new ResponseBean();
        try {
            actorService.updateActor(bean, actorId, actorDTO);
            LOGGER.info(actorDTO.toString());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

}
