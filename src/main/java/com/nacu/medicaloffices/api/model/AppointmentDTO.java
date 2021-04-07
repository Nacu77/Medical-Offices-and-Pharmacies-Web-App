package com.nacu.medicaloffices.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AppointmentDTO {

    private String description;
    private LocalDateTime date;
}
