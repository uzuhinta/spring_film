package com.quannar.film.controller;

import com.quannar.film.payload.request.CategoryDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.CategoryRepository;
import com.quannar.film.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/api")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/categories")
    ResponseEntity getAllType() {
        ResponseBean bean = new ResponseBean();
        categoryService.getAll(bean);
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/category")
    ResponseEntity createType(@Valid @RequestBody CategoryDTO categoryDTO) {
        ResponseBean bean = new ResponseBean();
        categoryService.create(bean, categoryDTO);
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping(path = "/secure/category/{id}")
    ResponseEntity deleteType(@PathVariable("id") Long typeId) {
        ResponseBean bean = new ResponseBean();
        categoryService.deleteCategoryById(bean, typeId);
        return ResponseEntity.ok(bean);
    }
}
