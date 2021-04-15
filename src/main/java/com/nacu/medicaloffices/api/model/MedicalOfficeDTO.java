package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MedicalOfficeDTO {

    private String name;
    private ContactDataDTO contactData;
    private AddressDTO address;
    private ScheduleDTO schedule;
    private SpecialtyDTO specialty;
    private List<AppointmentDTO> appointments;

    @Builder
    public MedicalOfficeDTO(String name, ContactDataDTO contactData, AddressDTO address, ScheduleDTO schedule, SpecialtyDTO specialty, List<AppointmentDTO> appointments) {
        this.name = name;
        this.contactData = contactData;
        this.address = address;
        this.schedule = schedule;
        this.specialty = specialty;
        this.appointments = appointments;
    }
}
