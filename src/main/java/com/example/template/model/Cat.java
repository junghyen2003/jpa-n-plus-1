package com.example.template.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private CatSlave catSlave;

    @Builder
    public Cat(String name, CatSlave catSlave) {
        this.name = name;
        this.catSlave = catSlave;
    }
}
