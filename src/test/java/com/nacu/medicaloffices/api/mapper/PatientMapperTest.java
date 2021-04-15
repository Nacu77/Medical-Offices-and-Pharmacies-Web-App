package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.AppointmentDTO;
import com.nacu.medicaloffices.api.model.ContactDataDTO;
import com.nacu.medicaloffices.api.model.PatientDTO;
import com.nacu.medicaloffices.api.model.RecipeDTO;
import com.nacu.medicaloffices.domain.Appointment;
import com.nacu.medicaloffices.domain.ContactData;
import com.nacu.medicaloffices.domain.Patient;
import com.nacu.medicaloffices.domain.Recipe;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientMapperTest {

    private final String FIRST_NAME = "Florin";
    private final String LAST_NAME = "Nacu";

    private final ContactData CONTACT_DATA = ContactData.builder().email("florin@email.com").build();
    private final Set<Recipe> RECIPES_SET = Set.of(
            Recipe.builder().build(),
            Recipe.builder().build()
    );
    private final Set<Appointment> APPOINTMENTS_SET = Set.of(
            Appointment.builder().build(),
            Appointment.builder().build()
    );

    private final ContactDataDTO CONTACT_DATA_DTO = ContactDataDTO.builder().email("florin@email.com").build();
    private final List<RecipeDTO> RECIPES_LIST = List.of(
            RecipeDTO.builder().build(),
            RecipeDTO.builder().build()
    );
    private final List<AppointmentDTO> APPOINTMENTS_LIST = List.of(
            AppointmentDTO.builder().build(),
            AppointmentDTO.builder().build()
    );

    private final PatientMapper patientMapper = PatientMapper.INSTANCE;

    @Test
    void patientToPatientDTO() {
        Patient patient = Patient.builder().firstName(FIRST_NAME).lastName(LAST_NAME).contactData(CONTACT_DATA).recipes(RECIPES_SET).appointments(APPOINTMENTS_SET).build();
        PatientDTO patientDTO = patientMapper.patientToPatientDTO(patient);

        assertEquals(FIRST_NAME, patientDTO.getFirstName());
        assertEquals(LAST_NAME, patientDTO.getLastName());
        assertEquals(CONTACT_DATA.getEmail(), patientDTO.getContactData().getEmail());
        assertEquals(RECIPES_SET.size(), patientDTO.getRecipes().size());
        assertEquals(APPOINTMENTS_SET.size(), patientDTO.getAppointments().size());
    }

    @Test
    void patientDTOtoPatient() {
        PatientDTO patientDTO = PatientDTO.builder().firstName(FIRST_NAME).lastName(LAST_NAME).contactData(CONTACT_DATA_DTO).recipes(RECIPES_LIST).appointments(APPOINTMENTS_LIST).build();
        Patient patient = patientMapper.patientDTOtoPatient(patientDTO);

        assertEquals(FIRST_NAME, patient.getFirstName());
        assertEquals(LAST_NAME, patient.getLastName());
        assertEquals(CONTACT_DATA_DTO.getEmail(), patient.getContactData().getEmail());
        assertEquals(RECIPES_LIST.size(), patient.getRecipes().size());
        assertEquals(APPOINTMENTS_LIST.size(), patient.getAppointments().size());
    }
}