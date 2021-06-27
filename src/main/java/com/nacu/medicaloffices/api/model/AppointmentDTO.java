package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;
    private String description;
    private LocalDateTime date;
    private Long patientId;
    private String patientName;
    private Long medicalOfficeId;
    private String medicalOfficeName;

    @Builder
    public AppointmentDTO(Long id, String description, LocalDateTime date, Long patientId, String patientName, Long medicalOfficeId, String medicalOfficeName) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.patientId = patientId;
        this.patientName = patientName;
        this.medicalOfficeId = medicalOfficeId;
        this.medicalOfficeName = medicalOfficeName;
    }
}
