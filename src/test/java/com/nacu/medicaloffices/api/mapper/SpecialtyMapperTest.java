package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.SpecialtyDTO;
import com.nacu.medicaloffices.domain.Specialty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyMapperTest {

    private final String NAME = "Neurology";

    private final SpecialtyMapper specialtyMapper = SpecialtyMapper.INSTANCE;

    @Test
    void specialtyToSpecialtyDTO() {
        Specialty specialty = Specialty.builder().name(NAME).build();
        SpecialtyDTO specialtyDTO = specialtyMapper.specialtyToSpecialtyDTO(specialty);

        assertEquals(NAME, specialtyDTO.getName());
    }

    @Test
    void specialtyDTOtoSpecialty() {
        SpecialtyDTO specialtyDTO = SpecialtyDTO.builder().name(NAME).build();
        Specialty specialty = specialtyMapper.specialtyDTOtoSpecialty(specialtyDTO);

        assertEquals(NAME, specialty.getName());
    }
}