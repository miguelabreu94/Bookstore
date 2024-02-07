package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "my_books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyBookCart {

    @Id
    private long id;
    private String name;
    private String author;
    private BookCategories category;
    private double price;

}

