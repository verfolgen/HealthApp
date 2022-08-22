package org.example.v1.drug.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Schema(description = "DTO for drug")
@Data
@NoArgsConstructor
public class DrugRecord {

    @Schema(description = "Id of drug")
    private Long id;

    @Schema(description = "Name of the drug DTO")
    private String name;

    @Schema(description = "Expiration date of the drug DTO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate before_date;

    @Schema(description = "Link for instructions drug DTO")
    private String instruction;
}
