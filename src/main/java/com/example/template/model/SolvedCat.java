package com.example.template.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class SolvedCat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private SolvedCatSlave solvedCatSlave;

    @Builder
    public SolvedCat(String name, SolvedCatSlave solvedCatSlave) {
        this.name = name;
        this.solvedCatSlave = solvedCatSlave;
    }
}
