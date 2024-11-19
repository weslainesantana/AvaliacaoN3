package com.weslaine.avaliacao_n3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weslaine.avaliacao_n3.models.PatientEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    
}
