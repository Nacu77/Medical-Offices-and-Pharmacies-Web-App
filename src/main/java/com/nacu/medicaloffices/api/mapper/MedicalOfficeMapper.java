package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicalOfficeDTO;
import com.nacu.medicaloffices.domain.MedicalOffice;
import com.nacu.medicaloffices.repositories.DoctorRepository;
import com.nacu.medicaloffices.repositories.SpecialtyRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        uses = {ContactDataMapper.class, AddressMapper.class, ScheduleMapper.class, SpecialtyMapper.class, AppointmentMapper.class},
        componentModel = "spring"
)
public abstract class MedicalOfficeMapper {

    @Autowired
    protected SpecialtyRepository specialtyRepository;

    @Autowired
    protected DoctorRepository doctorRepository;

    @Mapping(source = "doctor.id", target = "doctorId")
    public abstract MedicalOfficeDTO medicalOfficeToMedicalOfficeDTO(MedicalOffice medicalOffice);

    @Mapping(target = "specialty", expression = "java(specialtyRepository.findByName(medicalOfficeDTO.getSpecialty().getName()))")
    @Mapping(target = "doctor", expression = "java(doctorRepository.findById(medicalOfficeDTO.getDoctorId()).get())")
    public abstract MedicalOffice medicalOfficeDTOtoMedicalOffice(MedicalOfficeDTO medicalOfficeDTO);
}
