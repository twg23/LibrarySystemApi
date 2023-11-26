package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    @SequenceGenerator(
            name = "genre_seq",
            sequenceName = "genre_seq",
            initialValue = 1,
            allocationSize = 1

    )
    private  Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name ="author_id", referencedColumnName = "id", nullable = false)
    private Author author;


    @OneToOne
    @JoinColumn(name ="genre_id", referencedColumnName = "id",nullable = false )
    private Genre genre;


}

