package com.quannar.film.controller;

import com.quannar.film.payload.request.ReviewDTO;
import com.quannar.film.payload.request.TypeDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Autowired


    @GetMapping(path = "/review")
    ResponseEntity getAllReview() {
        ResponseBean bean = new ResponseBean();
        reviewService.getAll(bean);
        return ResponseEntity.ok(bean);
    }

    @PostMapping(path = "/secure/review")
    ResponseEntity createReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        ResponseBean bean = new ResponseBean();
        reviewService.create(bean, reviewDTO);
        return ResponseEntity.ok(bean);
    }

    @DeleteMapping(path = "/secure/review/{id}")
    ResponseEntity deleteReview(@PathVariable("id") Long typeId) {
        ResponseBean bean = new ResponseBean();
        reviewService.deleteReviewById(bean, typeId);
        return ResponseEntity.ok(bean);
    }
}
