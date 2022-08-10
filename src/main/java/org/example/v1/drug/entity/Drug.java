package org.example.v1.drug.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//Объект, описывающий какое лекарство
@Entity
@Table(name = "drug")
@Data
@NoArgsConstructor
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="created")
    private LocalDate created;

    //наименование лекарства
    @Column(name = "name")
    private String name;
    //Срок годности лекарства
    @Column (name = "before_date")
    private LocalDate before_date;
    //Ссылка для инструкции
    @Column (name = "instruction")
    private String instruction;

}

