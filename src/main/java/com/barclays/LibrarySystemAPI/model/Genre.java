package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "genre")
@Data
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
//    private String historical;
//    private String  fantasy;
//    private String  romance;
//    private String fiction;
//    private String science;
//    private String children;


}
