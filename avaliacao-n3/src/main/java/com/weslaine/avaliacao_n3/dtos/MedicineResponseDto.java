package com.weslaine.avaliacao_n3.dtos;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record MedicineResponseDto(
    Long id, 
    String name,
    String description, 
    String dose,
    @JsonFormat(pattern = "dd/MM/yyyy") 
    LocalDate expirationDate
) {
    
}
