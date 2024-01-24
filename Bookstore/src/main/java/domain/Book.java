package domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {
@Id
@SequenceGenerator(
        name = "book-sequence",
        sequenceName = "book-sequence",
        allocationSize = 1
)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book-sequence"
)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private BookCategories category;
    private String author;
    private double price;
    private int numberPages;

    public Book(String name, BookCategories type, String author, double price, int quantity) {
        this.name = name;
        this.category = type;
        this.author = author;
        this.price = price;
        this.numberPages = quantity;
    }
}
