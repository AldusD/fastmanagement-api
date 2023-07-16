package com.managecorp.fastmanagementapi.models;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    String email;

    String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
