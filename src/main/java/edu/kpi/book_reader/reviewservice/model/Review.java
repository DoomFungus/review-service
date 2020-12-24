package edu.kpi.book_reader.reviewservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews", uniqueConstraints={
                @UniqueConstraint(columnNames = {"book_id", "author"})})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "book_id", nullable = false)
    private Integer bookId;
    @Column(name = "author", nullable = false)
    private String authorName;
    @Column(nullable = false)
    private Integer rating;
    @Column
    private String text;
}
