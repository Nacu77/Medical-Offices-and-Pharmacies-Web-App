package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicalOfficeDTO;
import com.nacu.medicaloffices.domain.MedicalOffice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ContactDataMapper.class, AddressMapper.class, ScheduleMapper.class, SpecialtyMapper.class, AppointmentMapper.class})
public interface MedicalOfficeMapper {
    MedicalOfficeMapper INSTANCE = Mappers.getMapper(MedicalOfficeMapper.class);
    MedicalOfficeDTO medicalOfficeToMedicalOfficeDTO(MedicalOffice medicalOffice);
    MedicalOffice medicalOfficeDTOtoMedicalOffice(MedicalOfficeDTO medicalOfficeDTO);
}
