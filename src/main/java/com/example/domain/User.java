package com.example.domain;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String password;

    @Column
    private String username;
}
