package com.example.template.service;

import com.example.template.model.SolvedCatSlave;
import com.example.template.repository.SolvedCatRepository;
import com.example.template.repository.SolvedCatSlaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolvedCatSlaveService {
    private final SolvedCatSlaveRepository solvedCatSlaveRepository;

    public List<SolvedCatSlave> findAll() {
        return solvedCatSlaveRepository.findAll();
    }

    @Transactional
    public List<SolvedCatSlave> create(List<SolvedCatSlave> solvedCatSlaves) {
        return solvedCatSlaveRepository.saveAll(solvedCatSlaves);
    }
}
