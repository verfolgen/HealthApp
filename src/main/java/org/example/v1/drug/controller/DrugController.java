package org.example.v1.drug.controller;

import org.example.v1.drug.dto.DrugRecord;
import org.example.v1.drug.service.DrugService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/drugs")
public class DrugController {
    private final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DrugRecord>> findAllDrugs() {
        return new ResponseEntity<>(drugService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrugRecord> saveDrug (@RequestBody DrugRecord drugRecord) {
        drugService.save(drugRecord);
        return new ResponseEntity<>(drugRecord, HttpStatus.CREATED);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<DrugRecord> findByIdDrug (@PathVariable("id") Long id) {
        return drugService.findById(id);
    }

    @DeleteMapping(value = "/{drugId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDrug (@PathVariable Long drugId) {
        drugService.delete(drugId);
    }
}
