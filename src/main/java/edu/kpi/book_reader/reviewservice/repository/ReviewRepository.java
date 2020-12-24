package edu.kpi.book_reader.reviewservice.repository;

import edu.kpi.book_reader.reviewservice.model.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    Collection<Review> findAllByBookId(Integer bookId);

    @Query("SELECT AVG(e.rating) FROM Review e WHERE e.bookId = ?1")
    Double findAverageRatingByBookId(Integer bookId);
}
