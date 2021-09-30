package com.quannar.film.service.Impl;

import com.quannar.film.common.Constant;
import com.quannar.film.model.Type;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.TypeRepository;
import com.quannar.film.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void getAll(ResponseBean bean) throws Exception {
        List<Type> allType = typeRepository.getAllType();
        bean.addData("types", allType);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    public void create(ResponseBean bean, TypeDTO typeDTO) throws Exception {
        Type type = new Type(typeDTO.getName(), typeDTO.getDescription());
        typeRepository.saveAndFlush(type);
        bean.addData("type", type);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    @Transactional
    public void deleteTypeById(ResponseBean bean, Long typeId) throws Exception {
        Optional<Type> optionalType = typeRepository.getActorById(typeId);

        if (optionalType.isPresent()){

            typeRepository.deleteTypeById(typeId);

            bean.setMessage(Constant.MSG_DELETE_SUCCESS);
            bean.setError(Constant.ERROR_CODE_OK);
            bean.addData("type", optionalType);
        } else {
            bean.setMessage(Constant.MSG_NOT_FOUND);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
    }
}
