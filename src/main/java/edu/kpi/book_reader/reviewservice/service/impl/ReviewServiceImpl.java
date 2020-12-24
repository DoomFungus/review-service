package edu.kpi.book_reader.reviewservice.service.impl;

import edu.kpi.book_reader.reviewservice.model.Review;
import edu.kpi.book_reader.reviewservice.repository.ReviewRepository;
import edu.kpi.book_reader.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Collection<Review> findAllByBookId(int bookId) {
        return reviewRepository.findAllByBookId(bookId);
    }

    @Override
    public void createReview(Review review) {
        if(review.getRating()== null ||
                review.getRating()>5 ||
                review.getRating()<0){
            throw new IllegalArgumentException("Invalid rating value");
        }
        try {
            reviewRepository.save(review);
        } catch (Exception e){
            throw new IllegalArgumentException("Could not create review");
        }
    }

    @Override
    public Double findAverageRatingByBookId(int bookId) {
        return reviewRepository.findAverageRatingByBookId(bookId);
    }
}
