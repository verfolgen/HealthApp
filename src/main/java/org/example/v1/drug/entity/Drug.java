package org.example.v1.drug.entity;


import javax.persistence.*;
import java.io.Serializable;

//Объект, описывающий какое лекарство
@Entity
@Table(name = "druglist")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //наименование лекарства
    @Column(name = "name")
    private String name;
    //Срок годности лекарства
    @Column (name = "date")
    private String date;
    //Ссылка для инструкции
    @Column (name = "instruction")
    private String instruction;

    public Drug() {}

    public Drug(String name, String date, String instruction) {
        this.name = name;
        this.date = date;
        this.instruction = instruction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
