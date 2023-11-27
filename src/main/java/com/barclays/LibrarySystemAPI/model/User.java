package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "user_t")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_t_seq")
    @SequenceGenerator(
            name = "user_t_seq",
            sequenceName = "user_t_seq",
            initialValue = 1,
            allocationSize = 1

    )
    private  Long id;
    private String name;
    @NonNull
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;
    private String phoneNumber;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Booking> booking;

    public User(String name) {
        this.name = name;
    }

    public User(Long id, String name, @NonNull Address address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
