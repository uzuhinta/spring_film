package com.quannar.film.service;

import com.quannar.film.payload.request.CategoryDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;

public interface CategoryService {

    void getAll(ResponseBean bean) throws Exception;

    void create(ResponseBean bean, CategoryDTO categoryDTO) throws Exception;

    void deleteCategoryById(ResponseBean bean, Long categoryId) throws Exception;

}
