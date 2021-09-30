package com.quannar.film.service.Impl;

import com.quannar.film.common.Constant;
import com.quannar.film.model.Category;
import com.quannar.film.payload.request.CategoryDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.CategoryRepository;
import com.quannar.film.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void getAll(ResponseBean bean) {
        List<Category> allCategory = categoryRepository.getAllCategory();
        bean.addData("categories", allCategory);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    public void create(ResponseBean bean, CategoryDTO categoryDTO) {
        LOGGER.info(categoryDTO.toString());
        Category category = new Category(categoryDTO.getName(), categoryDTO.getDescription());
        categoryRepository.saveAndFlush(category);
        bean.addData("category", category);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    @Transactional
    public void deleteCategoryById(ResponseBean bean, Long categoryId) {

        Optional<Category> optionalCategory = categoryRepository.getCategoryById(categoryId);

        if (optionalCategory.isPresent()) {
            categoryRepository.deleteCategoryById(categoryId);
            bean.addData("category", optionalCategory);
            bean.setMessage(Constant.MSG_DELETE_SUCCESS);
            bean.setError(Constant.ERROR_CODE_OK);
        } else {
            bean.setDescription(Constant.MSG_NOT_FOUND);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
    }
}
