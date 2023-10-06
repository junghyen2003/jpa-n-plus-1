package com.example.template.service;

import com.example.template.model.CatSlave;
import com.example.template.repository.CatSlaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatSlaveService {
    private final CatSlaveRepository catSlaveRepository;

    public List<CatSlave> findAll() {
        return catSlaveRepository.findAll();
    }

    @Transactional
    public List<CatSlave> create(List<CatSlave> cats) {
        return catSlaveRepository.saveAll(cats);
    }

}
