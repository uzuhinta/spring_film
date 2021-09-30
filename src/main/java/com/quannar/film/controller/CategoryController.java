package com.quannar.film.controller;

import com.quannar.film.common.Constant;
import com.quannar.film.payload.request.CategoryDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.CategoryRepository;
import com.quannar.film.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/api")
public class CategoryController {

    private final CategoryService categoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/category")
    ResponseEntity getAllType() {
        ResponseBean bean = new ResponseBean();
        try {
            categoryService.getAll(bean);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/category")
    ResponseEntity createType(@Valid @RequestBody CategoryDTO categoryDTO) {
        ResponseBean bean = new ResponseBean();
        try {
            categoryService.create(bean, categoryDTO);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping(path = "/secure/category/{id}")
    ResponseEntity deleteType(@PathVariable("id") Long typeId) {
        ResponseBean bean = new ResponseBean();
        try {
            categoryService.deleteCategoryById(bean, typeId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }
}
