package com.quannar.film.controller;

import com.quannar.film.common.ConvertVI;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping(path = "/types")
    ResponseEntity getAllType() {
        ResponseBean bean = new ResponseBean();
        typeService.getAll(bean);
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/type")
    ResponseEntity createType(@Valid @RequestBody TypeDTO typeDTO) {
        ResponseBean bean = new ResponseBean();
        typeService.create(bean, typeDTO);
        return ResponseEntity.ok(bean);
    }
}
