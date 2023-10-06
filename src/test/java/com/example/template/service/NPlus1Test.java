package com.example.template.service;

import com.example.template.model.Cat;
import com.example.template.model.CatSlave;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class NPlus1Test {

    @Autowired
    private CatService catService;

    @Autowired
    private CatSlaveService catSlaveService;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Test
    void nPlus1Test() {
        List<Cat> cats = IntStream.rangeClosed(1, 10)
                .mapToObj(index -> Cat.builder()
                        .name("고양이".concat(String.valueOf(index)))
                        .build())
                .toList();

        catService.create(cats);

        List<CatSlave> catSlaves = IntStream.rangeClosed(1, 10)
                .mapToObj(index -> CatSlave.builder()
                        .name("집사".concat(String.valueOf(index)))
                        .cats(cats)
                        .build())
                .toList();

        catSlaveService.create(catSlaves);

        entityManager.clear();

        List<CatSlave> savedCatSlaves = catSlaveService.findAll();

        savedCatSlaves.forEach(savedCatSlave -> System.out.println(savedCatSlave.getCats().stream().map(Cat::getName).toList()));
    }
}