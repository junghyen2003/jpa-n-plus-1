package com.example.template.service;

import com.example.template.model.Cat;
import com.example.template.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {
    private final CatRepository catRepository;

    @Transactional
    public Cat create(Cat cat) {
        return catRepository.save(cat);
    }

    @Transactional
    public List<Cat> create(List<Cat> cats) {
        return catRepository.saveAll(cats);
    }

}
