package com.weslaine.avaliacao_n3.dtos;

import java.sql.Date;

public record MedicineResponseDto(
    Long id, 
    String name,
    String description, 
    String dose, 
    Date expirationDate
) {
    
}
