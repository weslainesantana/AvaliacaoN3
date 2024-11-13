package com.weslaine.avaliacao_n3.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.weslaine.avaliacao_n3.models.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Long>{
    @Override
    Page<MedicineEntity> findAll(Pageable pageable);
}
