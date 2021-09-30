package com.quannar.film.service;

import com.quannar.film.payload.request.CategoryDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;

public interface CategoryService {

    void getAll(ResponseBean bean);

    void create(ResponseBean bean, CategoryDTO categoryDTO);

    void deleteCategoryById(ResponseBean bean, Long categoryId);

}
