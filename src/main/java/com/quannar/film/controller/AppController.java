package com.quannar.film.controller;

import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping(path = "/")
    public ResponseEntity index() {
        ResponseBean bean = new ResponseBean();
        appService.hello(bean);
        return ResponseEntity.ok(bean);
    }
}
