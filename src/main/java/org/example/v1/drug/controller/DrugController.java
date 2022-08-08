package org.example.v1.drug.controller;

import org.example.v1.drug.service.DrugService;
import org.example.v1.drug.entity.Drug;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v1/drugs")
public class DrugController {
    private final DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping
    public String startPage() {
        return "welcome";
    }

    @GetMapping
    public String findAllDrugs(Model model) {
        model.addAttribute("drugs", drugService.findAll());
        return "listDrugs";
    }

    @GetMapping(value = "/add")
    public String addNewDrug() {
        return "addDrug";
    }


    @PostMapping
    public String save (@RequestParam String name, @RequestParam String date) {
        drugService.save(new Drug(name, date, "https://www.vidal.ru/search?t=all&q="+name));
        return "redirect:/v1/drugs";

    }

    @DeleteMapping(value = "/{drugId}")
    public void delete (@PathVariable Long drugId) {
        drugService.delete(drugId);
    }

    @GetMapping(value = "/{name}")
    public List<Drug> findByName (@PathVariable String name) {
        return drugService.findByName(name);
    }

    @GetMapping(value = "/{id}")
    public Optional<Drug> findById (@PathVariable Long id) {
        return drugService.findById(id);
    }
}
