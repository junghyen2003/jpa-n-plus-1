package com.example.template.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class SolvedCatSlave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @BatchSize(size = 20)
    @OneToMany(mappedBy = "solvedCatSlave")
    private Set<SolvedCat> solvedCats;

    @Builder
    public SolvedCatSlave(String name, Set<SolvedCat> solvedCats) {
        this.name = name;
        this.solvedCats = solvedCats;
    }
}
