package com.barclays.LibrarySystemAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity (name = "user_t")
@Data
@AllArgsConstructor
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

    public User(String name) {
        this.name = name;
    }
}
