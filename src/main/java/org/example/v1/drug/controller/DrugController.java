package org.example.v1.drug.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("api/v1/drugs")
@Tag(name = "Drugs", description = "All methods for working with drugs of the system")
public class DrugController {
    private final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a list of all drugs")
    public ResponseEntity<List<DrugRecord>> findAllDrugs() {
        return ResponseEntity.ok().body(drugService.findAllDrugs());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create new drug ")
    public ResponseEntity<DrugRecord> saveDrug (@Parameter(description = "DTO drug")
                                                    @RequestBody DrugRecord drugRecord) {
        drugService.saveDrug(drugRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Operation(summary = "Get drug by id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrugRecord> findByIdDrug (@Parameter(description = "Id of drug")
                                                        @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(drugService.findByIdDrug(id));
    }

    @Operation(summary = "Delete drug by id")
    @DeleteMapping(value = "/{drugId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDrug (@Parameter(description = "Id of drug")
                                @PathVariable Long drugId) {
        drugService.deleteDrugById(drugId);
    }
}
