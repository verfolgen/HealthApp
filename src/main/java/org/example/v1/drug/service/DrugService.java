package org.example.v1.drug.service;

import lombok.extern.slf4j.Slf4j;
import org.example.v1.drug.dto.DrugRecord;
import org.example.v1.drug.entity.Drug;
import org.example.v1.drug.mapper.DrugMapper;
import org.example.v1.drug.repository.DrugRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DrugService {

    private final DrugRepository drugRepository;

    public DrugService (DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Transactional
    public List <DrugRecord> findAllDrugs() {
        log.info("Start find all drugs");
        List<Drug> drugs = drugRepository.findAll();
        return drugs
                .stream()
                .map(DrugMapper.INSTANCE::toRecord)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveDrug (DrugRecord drugRecord) {
        log.info("Attempt save drug record {}", drugRecord);
        if (drugRecord == null) {
            log.error("Drug record isn't request {}", drugRecord);
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drug Record isn't in request");
        }
        Drug drugEntity = DrugMapper.INSTANCE.toEntity(drugRecord);
        drugEntity.setInstruction
                ("https://www.vidal.ru/search?t=all&q="+drugEntity.getName());
        drugEntity.setCreated(LocalDate.now());
        log.info("Successfully saved drug with id {}", drugRecord.getId());
        drugRepository.save(drugEntity);
    }

    @Transactional
    public void deleteDrugById (Long drugId) {
        log.info("Attempt delete drug by id {}", drugId);
        if(!drugRepository.existsById(drugId)) {
            log.error("Drug with id {} don't exist", drugId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drug with " + drugId + " don't exist");
        }
        log.info("Successfully delete drug {}", drugId);
        drugRepository.deleteById(drugId);
    }

    @Transactional
    public DrugRecord findByIdDrug(Long drugId) {
        log.info("Attempt find drug by id {}", drugId);
        return drugRepository
                .findById(drugId)
                .map(DrugMapper.INSTANCE::toRecord)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Drug with " + drugId + " don't exist"));
    }
}
