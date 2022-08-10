package org.example.v1.drug.mapper;


import org.example.v1.drug.dto.DrugRecord;
import org.example.v1.drug.entity.Drug;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DrugMapper {
    DrugMapper INSTANCE = Mappers.getMapper(DrugMapper.class);
    DrugRecord toRecord (Drug drug);

    Drug toEntity(DrugRecord drugRecord);
}
