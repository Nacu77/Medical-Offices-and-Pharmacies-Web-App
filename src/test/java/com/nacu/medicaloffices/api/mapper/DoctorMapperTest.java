package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.ContactDataDTO;
import com.nacu.medicaloffices.api.model.MedicalOfficeDTO;
import com.nacu.medicaloffices.domain.ContactData;
import com.nacu.medicaloffices.domain.MedicalOffice;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class DoctorMapperTest {

    private final String FIRST_NAME = "Andreea";
    private final String LAST_NAME = "Cristea";

    private final ContactData CONTACT_DATA = ContactData.builder().phoneNumber("0761111111").email("florin@email.com").build();
    private final Set<MedicalOffice> MEDICAL_OFFICES_SET = Set.of(
            MedicalOffice.builder().build(),
            MedicalOffice.builder().build()
    );

    private final ContactDataDTO CONTACT_DATA_DTO = ContactDataDTO.builder().phoneNumber("0761111111").email("florin@email.com").build();
    private final List<MedicalOfficeDTO> MEDICAL_OFFICES_LIST = List.of(
            MedicalOfficeDTO.builder().build(),
            MedicalOfficeDTO.builder().build()
    );

    private final DoctorMapper doctorMapper = DoctorMapper.INSTANCE;

    @Test
    void doctorToDoctorDTO() {
//        Doctor doctor = Doctor.builder().firstName(FIRST_NAME).lastName(LAST_NAME).contactData(CONTACT_DATA).medicalOffices(MEDICAL_OFFICES_SET).build();
//        DoctorDTO doctorDTO = doctorMapper.doctorToDoctorDTO(doctor);
//
//        assertEquals(FIRST_NAME, doctorDTO.getFirstName());
//        assertEquals(LAST_NAME, doctorDTO.getLastName());
//        assertEquals(CONTACT_DATA.getEmail(), doctorDTO.getContactData().getEmail());
//        assertEquals(MEDICAL_OFFICES_SET.size(), doctorDTO.getMedicalOffices().size());
    }

    @Test
    void doctorDTOtoDoctor() {
//        DoctorDTO doctorDTO = DoctorDTO.builder().firstName(FIRST_NAME).lastName(LAST_NAME).contactData(CONTACT_DATA_DTO).medicalOffices(MEDICAL_OFFICES_LIST).build();
//        Doctor doctor = doctorMapper.doctorDTOtoDoctor(doctorDTO);
//
//        assertEquals(FIRST_NAME, doctor.getFirstName());
//        assertEquals(LAST_NAME, doctor.getLastName());
//        assertEquals(CONTACT_DATA_DTO.getEmail(), doctor.getContactData().getEmail());
//        assertEquals(MEDICAL_OFFICES_LIST.size(), doctor.getMedicalOffices().size());
    }
}