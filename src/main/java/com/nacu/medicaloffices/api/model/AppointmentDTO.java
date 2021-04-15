package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AppointmentDTO {

    private String description;
    private LocalDateTime date;

    @Builder
    public AppointmentDTO(String description, LocalDateTime date) {
        this.description = description;
        this.date = date;
    }
}
