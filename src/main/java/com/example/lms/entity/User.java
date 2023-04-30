package com.example.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @Column(name = "user_id")
    private int userId;
    private String name;
    private String email;
    private String password;
    @Column(name = "user_type")
    private String userType;
}

