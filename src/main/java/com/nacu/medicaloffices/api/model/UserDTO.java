package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private RoleDTO role;
    private DoctorDTO doctor;
    private PatientDTO patient;
    private PharmacyOwnerDTO pharmacyOwner;

    @Builder
    public UserDTO(Long id, String username, String password, RoleDTO role, DoctorDTO doctor, PatientDTO patient, PharmacyOwnerDTO pharmacyOwner) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.doctor = doctor;
        this.patient = patient;
        this.pharmacyOwner = pharmacyOwner;
    }
}
