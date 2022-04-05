package com.example.javasample.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString(of = {"id", "name"}) @AllArgsConstructor
@Builder
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();
}