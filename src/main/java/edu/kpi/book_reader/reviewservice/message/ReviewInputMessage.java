package edu.kpi.book_reader.reviewservice.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.kpi.book_reader.reviewservice.model.Review;
import lombok.Data;

@Data
public class ReviewInputMessage {
    @JsonProperty("book_id")
    private Integer bookId;
    @JsonProperty("author")
    private String authorName;
    @JsonProperty
    private Integer rating;
    @JsonProperty
    private String text;

    public Review toReview(){
        Review review = new Review();
        review.setBookId(this.getBookId());
        review.setAuthorName(this.getAuthorName());
        review.setRating(this.getRating());
        review.setText(this.getText());
        return review;
    }
}
