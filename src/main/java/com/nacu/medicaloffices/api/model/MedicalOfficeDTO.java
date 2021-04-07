package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicalOfficeDTO {

    private String name;
    private ContactDataDTO contactData;
    private AddressDTO address;
    private ScheduleDTO scheduleDTO;
    private SpecialtyDTO specialty;

    @Builder
    public MedicalOfficeDTO(String name, ContactDataDTO contactData, AddressDTO address, ScheduleDTO scheduleDTO, SpecialtyDTO specialty) {
        this.name = name;
        this.contactData = contactData;
        this.address = address;
        this.scheduleDTO = scheduleDTO;
        this.specialty = specialty;
    }
}
