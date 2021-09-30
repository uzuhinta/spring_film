package com.quannar.film.controller;

import com.quannar.film.common.Constant;
import com.quannar.film.common.ConvertVI;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TypeController {

    private final TypeService typeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeController.class);

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping(path = "/type")
    ResponseEntity getAllType() {
        ResponseBean bean = new ResponseBean();
        try {
            typeService.getAll(bean);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/type")
    ResponseEntity createType(@Valid @RequestBody TypeDTO typeDTO) {
        ResponseBean bean = new ResponseBean();
        try {
            typeService.create(bean, typeDTO);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping(path = "/secure/type/{id}")
    ResponseEntity deleteType(@PathVariable("id") Long typeId) {
        ResponseBean bean = new ResponseBean();
        try {
            typeService.deleteTypeById(bean, typeId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }
}
