package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.PatientDTO;
import com.nacu.medicaloffices.domain.Patient;
import org.mapstruct.Mapper;

@Mapper(
        uses = { ContactDataMapper.class, RecipeMapper.class, AppointmentMapper.class },
        componentModel = "spring"
)
public interface PatientMapper {
    PatientDTO patientToPatientDTO(Patient patient);
    Patient patientDTOtoPatient(PatientDTO patientDTO);
}
