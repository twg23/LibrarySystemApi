package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "genre")
@Data
@NoArgsConstructor

public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    @SequenceGenerator(
            name = "genre_seq",
            sequenceName = "genre_seq",
            initialValue = 1,
            allocationSize = 1

    )
    private  Long id;
    private String bookGenre;
    private String movieGenre;


    public Genre(Long id, String bookGenre) {
        this.id = id;
        this.bookGenre = bookGenre;
    }


}
