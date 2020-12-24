package edu.kpi.book_reader.reviewservice.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.kpi.book_reader.reviewservice.model.Review;
import lombok.Data;

@Data
public class ReviewOutputMessage {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private Integer bookId;
    @JsonProperty("author")
    private String authorName;
    @JsonProperty
    private Integer rating;
    @JsonProperty
    private String text;

    public static ReviewOutputMessage fromReview(Review review){
        ReviewOutputMessage message = new ReviewOutputMessage();
        message.setId(review.getId());
        message.setBookId(review.getBookId());
        message.setAuthorName(review.getAuthorName());
        message.setRating(review.getRating());
        message.setText(review.getText());
        return message;
    }
}
