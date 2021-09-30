package com.quannar.film.service.Impl;

import com.quannar.film.common.Constant;
import com.quannar.film.model.Review;
import com.quannar.film.payload.request.ReviewDTO;
import com.quannar.film.payload.response.ResponseBean;
import com.quannar.film.repository.ReviewRepository;
import com.quannar.film.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(ReviewServiceImpl.class);

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void getAll(ResponseBean bean) {
        List<Review> reviews = reviewRepository.getAll();
        bean.addData("reviews", reviews);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    public void create(ResponseBean bean, ReviewDTO reviewDTO) {
        LOGGER.info(reviewDTO.toString());
        Review review = new Review(reviewDTO.getSummary(), reviewDTO.getShort_description(), reviewDTO.getContent());
        reviewRepository.saveAndFlush(review);
        bean.addData("review", review);
        bean.setDescription(Constant.MSG_CREATE_SUCCESS);
        bean.setError(Constant.ERROR_CODE_OK);
    }

    @Override
    @Transactional
    public void deleteReviewById(ResponseBean bean, Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.getReviewById(reviewId);
        if (optionalReview.isPresent()) {
            reviewRepository.deleteReviewById(reviewId);
            bean.addData("review", optionalReview);
            bean.setDescription(Constant.MSG_DELETE_SUCCESS);
            bean.setError(Constant.ERROR_CODE_OK);
        } else {
            bean.setDescription(Constant.MSG_NOT_FOUND);
            bean.setError(Constant.ERROR_CODE_NOK);
        }
    }
}
