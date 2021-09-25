package com.quannar.film.service.Impl;

import com.quannar.film.common.Constant;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.service.AppService;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

    @Override
    public void hello(ResponseBean bean) {
        bean.setError(Constant.ERROR_CODE_OK);
        bean.setMessage("Hello APP");
    }
}
