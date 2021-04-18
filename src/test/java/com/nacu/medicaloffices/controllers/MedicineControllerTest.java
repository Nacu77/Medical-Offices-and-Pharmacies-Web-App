package com.nacu.medicaloffices.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.services.MedicineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MedicineControllerTest {

    private final String BASE_URL = MedicineController.BASE_URL;
    private final String NAME = "Aspirin";

    @Mock
    private MedicineService service;

    @InjectMocks
    private MedicineController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAll() throws Exception {
        when(service.findAll())
                .thenReturn(List.of(
                        MedicineDTO.builder().name(NAME).build(),
                        MedicineDTO.builder().build()
                ));

        mockMvc.perform(get(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", equalTo(NAME)));
    }

    @Test
    void getById() throws Exception {
        when(service.findById(anyLong()))
                .thenReturn(
                        MedicineDTO.builder().name(NAME).build()
                );

        mockMvc.perform(get(BASE_URL + "/1")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)));
    }

    @Test
    void create() throws Exception {
        MedicineDTO dto = MedicineDTO.builder().name(NAME).build();

        when(service.create(any(MedicineDTO.class)))
                .thenReturn(dto);

        mockMvc.perform(post(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo(NAME)));
    }

    @Test
    void update() throws Exception {
        MedicineDTO dto = MedicineDTO.builder().name(NAME).build();

        when(service.saveById(anyLong(), any(MedicineDTO.class)))
                .thenReturn(dto);

        mockMvc.perform(put(BASE_URL + "/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)));
    }

    @Test
    void deleteTest() throws Exception {
        mockMvc.perform(delete(BASE_URL + "/1")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteById(anyLong());
    }
}