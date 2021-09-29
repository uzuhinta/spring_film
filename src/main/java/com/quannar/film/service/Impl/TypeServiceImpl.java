package com.quannar.film.service.Impl;

import com.quannar.film.common.Constant;
import com.quannar.film.model.Type;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.TypeRepository;
import com.quannar.film.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void getAll(ResponseBean bean) {
        List<Type> allType = typeRepository.getAllType();
        bean.addData("types", allType);
        bean.setError(Constant.ERROR_CODE_OK);
    }
}
