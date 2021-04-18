package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.MedicineMapper;
import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.domain.Medicine;
import com.nacu.medicaloffices.repositories.MedicineRepository;
import com.nacu.medicaloffices.services.MedicineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class MedicineServiceImplTest {

    private final String NAME = "Aspirin";

    @Mock
    private MedicineRepository medicineRepository;

    private MedicineService medicineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        medicineService = new MedicineServiceImpl(medicineRepository, MedicineMapper.INSTANCE);
    }

    @Test
    void findAll() {
        when(medicineRepository.findAll())
                .thenReturn(List.of(
                        Medicine.builder().name(NAME).build(),
                        Medicine.builder().build()
                ));
        List<MedicineDTO> medicines = medicineService.findAll();

        assertEquals(2, medicines.size());
        assertEquals(NAME, medicines.get(0).getName());
    }

    @Test
    void findById() {
        when(medicineRepository.findById(anyLong()))
                .thenReturn(Optional.of(
                        Medicine.builder().name(NAME).build()
                ));
        MedicineDTO medicineDTO = medicineService.findById(1L);

        assertEquals(NAME, medicineDTO.getName());
    }

    @Test
    void create() {
        when(medicineRepository.save(any(Medicine.class)))
                .thenReturn(
                        Medicine.builder().id(1L).name(NAME).build()
                );
        MedicineDTO returnDTO = medicineService.create(MedicineDTO.builder().name(NAME).build());

        assertEquals(NAME, returnDTO.getName());
    }

    @Test
    void saveById() {
        when(medicineRepository.save(any(Medicine.class)))
                .thenReturn(
                        Medicine.builder().id(1L).name(NAME).build()
                );
        MedicineDTO returnDTO = medicineService.saveById(1L, MedicineDTO.builder().name(NAME).build());

        assertEquals(NAME, returnDTO.getName());
    }

    @Test
    void deleteById() {
        medicineService.deleteById(1L);
        verify(medicineRepository, times((1))).deleteById(1L);
    }
}