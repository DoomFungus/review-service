package edu.kpi.book_reader.reviewservice.service;

import edu.kpi.book_reader.reviewservice.model.Review;

import java.util.Collection;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> findById(Integer id);

    Collection<Review> findAllByBookId(int bookId);

    void createReview(Review review);

    Double findAverageRatingByBookId(int bookId);
}
