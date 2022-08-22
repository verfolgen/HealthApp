package org.example.v1.drug.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Schema(description = "Entity for store medicine(drug)")
@Entity
@Table(name = "drug")
@Data
@NoArgsConstructor
public class Drug {
    @Schema(description = "Id of drug")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Date of creation of the drug")
    @Column(name="created")
    private LocalDate created;

    @Schema(description = "Name of the drug")
    @NotBlank
    @Max(50)
    @Column(name = "name")
    private String name;

    @Schema(description = "Expiration date of the drug")
    @Column (name = "before_date")
    private LocalDate before_date;

    @Schema(description = "Link for instructions")
    @Column (name = "instruction")
    private String instruction;

}

