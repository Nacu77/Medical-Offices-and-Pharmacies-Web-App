package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.PatientDTO;
import com.nacu.medicaloffices.domain.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    PatientDTO patientToPatientDTO(Patient patient);
    Patient patientDTOtoPatient(PatientDTO patientDTO);
}
