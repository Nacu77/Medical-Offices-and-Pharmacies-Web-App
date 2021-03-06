package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.DoctorDTO;
import com.nacu.medicaloffices.domain.Doctor;
import org.mapstruct.Mapper;

@Mapper(
        uses = {ContactDataMapper.class, MedicalOfficeMapper.class},
        componentModel = "spring"
)
public interface DoctorMapper {
    DoctorDTO doctorToDoctorDTO(Doctor doctor);
    Doctor doctorDTOtoDoctor(DoctorDTO doctorDTO);
}
