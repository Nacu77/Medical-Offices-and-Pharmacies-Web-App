package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.SpecialtyDTO;
import com.nacu.medicaloffices.domain.Specialty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SpecialtyMapper {
    SpecialtyMapper INSTANCE = Mappers.getMapper(SpecialtyMapper.class);
    SpecialtyDTO specialtyToSpecialtyDTO(Specialty specialty);
    Specialty specialtyDTOtoSpecialty(SpecialtyDTO specialtyDTO);
}
