package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicalOfficeDTO;
import com.nacu.medicaloffices.domain.MedicalOffice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {ContactDataMapper.class, AddressMapper.class, ScheduleMapper.class, SpecialtyMapper.class, AppointmentMapper.class},
        componentModel = "spring"
)
public interface MedicalOfficeMapper {
    MedicalOfficeMapper INSTANCE = Mappers.getMapper(MedicalOfficeMapper.class);

    @Mapping(source = "doctor.id", target = "doctorId")
    MedicalOfficeDTO medicalOfficeToMedicalOfficeDTO(MedicalOffice medicalOffice);

    MedicalOffice medicalOfficeDTOtoMedicalOffice(MedicalOfficeDTO medicalOfficeDTO);
}
