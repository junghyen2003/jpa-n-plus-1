package com.example.template.service;

import com.example.template.model.SolvedCat;
import com.example.template.repository.SolvedCatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SolvedCatService {
    private final SolvedCatRepository solvedCatRepository;

    @Transactional
    public SolvedCat create(SolvedCat solvedCat) {
        return solvedCatRepository.save(solvedCat);
    }

    @Transactional
    public List<SolvedCat> create(Set<SolvedCat> solvedCats) {
        return solvedCatRepository.saveAll(solvedCats);
    }
}
