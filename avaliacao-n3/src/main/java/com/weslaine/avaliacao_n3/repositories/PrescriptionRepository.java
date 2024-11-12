package com.weslaine.avaliacao_n3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weslaine.avaliacao_n3.models.PrescriptionEntity;

public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Long> {
    
}
