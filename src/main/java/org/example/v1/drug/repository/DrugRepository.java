package org.example.v1.drug.repository;

import org.springframework.data.repository.CrudRepository;
import org.example.v1.drug.entity.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends CrudRepository<Drug, Long> {

    List<Drug> findByName(String name);
}
