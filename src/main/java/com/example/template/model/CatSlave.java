package com.example.template.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CatSlave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "catSlave")
    private List<Cat> cats;

    @Builder
    public CatSlave(String name, List<Cat> cats) {
        this.name = name;
        this.cats = cats;
    }
}
