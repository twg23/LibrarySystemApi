package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservedItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserved_seq")
    @SequenceGenerator(
            name = "reserved_seq",
            sequenceName = "reserved_seq",
            initialValue = 100,
            allocationSize = 1

    )
    private Long id;
    @Enumerated(EnumType.STRING)
    ItemType  itemType;
    @OneToOne
    @JoinColumn(name ="item_id", referencedColumnName = "id",nullable = false )
    private Item item;
    private String date;
    private int period;
    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id",nullable = false )
   private User user;


}
