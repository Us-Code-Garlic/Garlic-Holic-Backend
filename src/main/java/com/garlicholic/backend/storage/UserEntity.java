package com.garlicholic.backend.storage;

import lombok.Getter;
import jakarta.persistence.*;

@Getter
@Entity
@Table(name = "user_tb")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

}
