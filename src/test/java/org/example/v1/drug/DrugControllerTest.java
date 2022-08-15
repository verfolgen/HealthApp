package org.example.v1.drug;

import org.example.v1.base.AbstractIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.v1.drug.dto.DrugRecord;
import org.example.v1.drug.entity.Drug;
import org.example.v1.drug.repository.DrugRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

        Drug drug1 = new Drug();
        drug.setName("Pentalgin");
        drug.setInstruction("Instruction pentalgin");
        drug.setBefore_date(LocalDate.of(2022, 8, 9));
        drugRepository.save(drug1);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/drugs")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2));
    }

    @Transactional
    @Test
    void saveDrug() throws Exception{
        DrugRecord drugRecord = new DrugRecord();
        drugRecord.setName("Arbidol");
        drugRecord.setInstruction("Instruction arbidol");

        mockMvc.perform(post("/api/v1/drugs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(drugRecord))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}