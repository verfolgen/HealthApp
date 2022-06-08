package org.example.v1.drug.service;

import org.example.v1.drug.entity.Drug;
import org.example.v1.drug.repository.DrugRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService {

    private final DrugRepository drugRepository;

    public DrugService (DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Transactional
    public List <Drug> findAll() {
        List <Drug> drugList = (ArrayList) drugRepository.findAll();
        return drugList;
    }

    @Transactional
    public void save (Drug drug) {
        drugRepository.save(drug);
    }

    @Transactional
    public void delete (Long id) {
        drugRepository.deleteById(id);
    }

    @Transactional
    public List <Drug> find(String name) {
        List <Drug> drugFind = drugRepository.findByName(name);
        return drugFind;
    }
}
