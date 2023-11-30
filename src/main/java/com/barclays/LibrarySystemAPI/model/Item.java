package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(
            name = "item_seq",
            sequenceName = "item_seq",
            initialValue = 1,
            allocationSize = 1

    )
    private  Long id;
    @Enumerated(EnumType.STRING)
    ItemType  itemType;

    private  String itemTitle;
//    @OneToOne
//    @JoinColumn(name ="book_id", referencedColumnName = "id",nullable = false )
//    private Book book;
//    @OneToOne
//    @JoinColumn(name ="movie_id", referencedColumnName = "id",nullable = false )
//    private Movie movie;



}
