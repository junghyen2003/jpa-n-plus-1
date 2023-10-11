package com.example.template.service;

import com.example.template.model.Cat;
import com.example.template.model.CatSlave;
import com.example.template.model.SolvedCat;
import com.example.template.model.SolvedCatSlave;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class NPlus1Test {

    @Autowired
    private CatService catService;

    @Autowired
    private CatSlaveService catSlaveService;

    @Autowired
    private SolvedCatService solvedCatService;

    @Autowired
    private SolvedCatSlaveService solvedCatSlaveService;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Test
    void nPlus1Test() {
        List<CatSlave> catSlaves = IntStream.rangeClosed(1, 10)
                .mapToObj(index -> CatSlave.builder()
                        .name("집사".concat(String.valueOf(index)))
                        .build())
                .toList();

        catSlaveService.create(catSlaves);

        catSlaves.forEach(catSlave -> {
            List<Cat> cats = IntStream.rangeClosed(1, 10)
                    .mapToObj(index -> Cat.builder()
                            .name("고양이".concat(String.valueOf(index)))
                            .catSlave(catSlave)
                            .build())
                    .toList();

            catService.create(cats);
        });

        entityManager.clear();

        List<CatSlave> savedCatSlaves = catSlaveService.findAll();

        savedCatSlaves.forEach(savedCatSlave -> System.out.println(savedCatSlave.getCats().stream().map(Cat::getName).toList()));
    }

    @Transactional
    @Test
    void nPlus1SolveTest() {
        List<SolvedCatSlave> solvedCatSlaves = IntStream.rangeClosed(1, 10)
                .mapToObj(index -> SolvedCatSlave.builder()
                        .name("집사".concat(String.valueOf(index)))
                        .build())
                .toList();

        solvedCatSlaveService.create(solvedCatSlaves);

        solvedCatSlaves.forEach(solvedCatSlave -> {
            Set<SolvedCat> solvedCats = IntStream.rangeClosed(1, 10)
                    .mapToObj(index -> SolvedCat.builder()
                            .name("고양이".concat(String.valueOf(index)))
                            .solvedCatSlave(solvedCatSlave)
                            .build())
                    .collect(Collectors.toSet());

            solvedCatService.create(solvedCats);
        });

        entityManager.clear();

        List<SolvedCatSlave> savedSolvedCatSlaves = solvedCatSlaveService.findAll();

        savedSolvedCatSlaves.forEach(savedSolvedCatSlave -> System.out.println(savedSolvedCatSlave.getSolvedCats().stream().map(SolvedCat::getName).toList()));
    }
}