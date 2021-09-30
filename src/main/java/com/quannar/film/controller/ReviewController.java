package com.quannar.film.controller;

import com.quannar.film.common.Constant;
import com.quannar.film.payload.request.ReviewDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class ReviewController {

    private final ReviewService reviewService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewService.class);

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Autowired


    @GetMapping(path = "/review")
    ResponseEntity getAllReview() {
        ResponseBean bean = new ResponseBean();
        try {
            reviewService.getAll(bean);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/review")
    ResponseEntity createReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        ResponseBean bean = new ResponseBean();
        try {
            reviewService.create(bean, reviewDTO);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping(path = "/secure/review/{id}")
    ResponseEntity deleteReview(@PathVariable("id") Long typeId) {
        ResponseBean bean = new ResponseBean();
        try {
            reviewService.deleteReviewById(bean, typeId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            bean.setDescription(Constant.MSG_SERVER_ERROR);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
        return ResponseEntity.ok(bean);
    }
}
