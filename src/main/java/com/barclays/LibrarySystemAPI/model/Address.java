package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "address_t")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_t_seq")
//    @SequenceGenerator(
//            name = "address_t_seq",
//            sequenceName = "address_t_seq",
//            initialValue = 1,
//            allocationSize = 1
//

    private  Long id;
    private String lineOne;
    private String city;
    private String postCode;
    private String country;
}
