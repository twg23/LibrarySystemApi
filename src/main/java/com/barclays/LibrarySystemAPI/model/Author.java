package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;


@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @SequenceGenerator(
            name = "author_seq",
            sequenceName = "author_seq",
            initialValue = 1,
            allocationSize = 1

    )
    private  Long id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}

