package edu.kpi.book_reader.reviewservice.controller;

import edu.kpi.book_reader.reviewservice.message.ReviewInputMessage;
import edu.kpi.book_reader.reviewservice.message.ReviewOutputMessage;
import edu.kpi.book_reader.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/review")
public class ReviewController {
    ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public void saveReview(@RequestBody ReviewInputMessage message){
        try {
            reviewService.createReview(message.toReview());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create Review");
        }
    }

    @GetMapping("/{id}")
    public ReviewOutputMessage findReview(@PathVariable("id") Integer id){
        return ReviewOutputMessage
                .fromReview(reviewService
                        .findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find Review")));
    }

    @GetMapping
    public Collection<ReviewOutputMessage> findReviewsByBook(@RequestParam("book_id") Integer bookId){
        return reviewService
                .findAllByBookId(bookId)
                .stream()
                .map(ReviewOutputMessage::fromReview)
                .collect(Collectors.toList());
    }

    @GetMapping("/avg")
    public Double findAverageRatingForBook(@RequestParam("book_id") Integer bookId){
        return reviewService.findAverageRatingByBookId(bookId);
    }
}
