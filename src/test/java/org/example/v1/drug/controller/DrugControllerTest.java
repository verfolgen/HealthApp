package org.example.v1.drug.controller;

import base.AbstractIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.v1.drug.dto.DrugRecord;
import org.example.v1.drug.entity.Drug;
import org.example.v1.drug.repository.DrugRepository;
import org.example.v1.drug.service.DrugService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DrugControllerTest extends AbstractIntegrationTest {

    @Autowired
    protected DrugRepository drugRepository;


    private ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

    @Transactional
    @Test
    void findAllDrugs() throws Exception{
        Drug drug = new Drug();
        drug.setName("Arbidol");
        drug.setInstruction("Instruction arbidol");
        drug.setBefore_date(LocalDate.of(2022, 1, 1));
        drugRepository.save(drug);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/drugs")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Arbidol"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].instruction").value("Instruction arbidol"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].before_date").value("2022-01-01"));
    }

    @Transactional
    @Test
    void saveDrug() throws Exception{
        DrugRecord drugRecord = new DrugRecord();
        drugRecord.setName("Arbidol");
        drugRecord.setInstruction("Instruction arbidol");

        mockMvc.perform(post("/v1/drugs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(drugRecord))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}