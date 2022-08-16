package org.example.v1.drug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.v1.drug.entity.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
}
