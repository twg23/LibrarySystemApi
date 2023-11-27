package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(
            name = "booking_seq",
            sequenceName = "booking_seq",
            initialValue = 1,
            allocationSize = 1

    )
    private Long id;
    @OneToOne
    @JoinColumn(name ="book_id", referencedColumnName = "id",nullable = false )
    private Book book;
    private String date;
    private int period;
    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id",nullable = false )
   private User user;


}
