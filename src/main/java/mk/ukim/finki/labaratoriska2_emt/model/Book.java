package mk.ukim.finki.labaratoriska2_emt.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    public Book () {

    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    private Integer availableCopies;


}
