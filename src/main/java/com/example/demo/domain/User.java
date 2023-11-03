package com.example.demo.domain;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "user_name", length = 50)
    private String name;

    @NotNull
    @Column(name = "user_email", length = 100)
    private String email;

    @NotNull
    @Column(name = "user_password")
    private String password;

//    @OneToMany(mappedBy = "user")
//    private List<Reservation> reservations = new ArrayList<>();
}
