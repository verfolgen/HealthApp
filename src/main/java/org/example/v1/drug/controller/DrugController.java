package org.example.v1.drug.controller;

import org.example.v1.drug.service.DrugService;
import org.example.v1.drug.entity.Drug;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DrugController {
    private final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping(value = "/drugs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Drug> findAllDrugs() {
        return drugService.findAll();
    }


    @PostMapping(value = "/drugs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveDrug (@RequestBody Drug drug) {
        drugService.save(drug);
    }


    @DeleteMapping(value = "/drugs/{drugId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDrug (@PathVariable Long drugId) {
        drugService.delete(drugId);
    }


    @GetMapping(value = "/drugs/{name}")
    public List<Drug> findDrug (@PathVariable String name) {
        return drugService.find(name);
    }
}
