package com.quannar.film.service;

import com.quannar.film.payload.request.ReviewDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;

public interface ReviewService {

    void getAll(ResponseBean bean) throws Exception;

    void create(ResponseBean bean, ReviewDTO reviewDTO) throws Exception;

    void deleteReviewById(ResponseBean bean, Long reviewId) throws Exception;

}
