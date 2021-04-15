package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.*;
import com.nacu.medicaloffices.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicalOfficeMapperTest {

    private final String NAME = "Cristea's Office";

    private final ContactData CONTACT_DATA = ContactData.builder().phoneNumber("0761111111").email("florin@email.com").build();
    private final Address ADDRESS = Address.builder().country("Romania").city("Iasi").street("Stefan cel Mare").number(77).build();
    private final Schedule SCHEDULE = Schedule.builder().mondayStart(LocalTime.NOON).mondayEnd(LocalTime.MIDNIGHT).build();
    private final Specialty SPECIALTY = Specialty.builder().name("Neurology").build();
    private final Set<Appointment> APPOINTMENTS_SET = Set.of(
            Appointment.builder().build(),
            Appointment.builder().build()
    );

    private final ContactDataDTO CONTACT_DATA_DTO = ContactDataDTO.builder().phoneNumber("0761111111").email("florin@email.com").build();
    private final AddressDTO ADDRESS_DTO = AddressDTO.builder().country("Romania").city("Iasi").street("Stefan cel Mare").number(77).build();
    private final ScheduleDTO SCHEDULE_DTO = ScheduleDTO.builder().mondayStart(LocalTime.NOON).mondayEnd(LocalTime.MIDNIGHT).build();
    private final SpecialtyDTO SPECIALTY_DTO = SpecialtyDTO.builder().name("Neurology").build();
    private final List<AppointmentDTO> APPOINTMENTS_LIST = List.of(
            AppointmentDTO.builder().build(),
            AppointmentDTO.builder().build()
    );

    private final MedicalOfficeMapper medicalOfficeMapper = MedicalOfficeMapper.INSTANCE;

    @Test
    void medicalOfficeToMedicalOfficeDTO() {
        MedicalOffice medicalOffice = MedicalOffice.builder().name(NAME).contactData(CONTACT_DATA).address(ADDRESS).schedule(SCHEDULE).specialty(SPECIALTY).appointments(APPOINTMENTS_SET).build();
        MedicalOfficeDTO medicalOfficeDTO = medicalOfficeMapper.medicalOfficeToMedicalOfficeDTO(medicalOffice);

        assertEquals(NAME, medicalOfficeDTO.getName());
        assertEquals(CONTACT_DATA.getEmail(), medicalOfficeDTO.getContactData().getEmail());
        assertEquals(ADDRESS.getCity(), medicalOfficeDTO.getAddress().getCity());
        assertEquals(SCHEDULE.getMondayStart(), medicalOfficeDTO.getSchedule().getMondayStart());
        assertEquals(SPECIALTY.getName(), medicalOfficeDTO.getSpecialty().getName());
        assertEquals(APPOINTMENTS_SET.size(), medicalOfficeDTO.getAppointments().size());
    }

    @Test
    void medicalOfficeDTOtoMedicalOffice() {
        MedicalOfficeDTO medicalOfficeDTO = MedicalOfficeDTO.builder().name(NAME).contactData(CONTACT_DATA_DTO).address(ADDRESS_DTO).schedule(SCHEDULE_DTO).specialty(SPECIALTY_DTO).appointments(APPOINTMENTS_LIST).build();
        MedicalOffice medicalOffice = medicalOfficeMapper.medicalOfficeDTOtoMedicalOffice(medicalOfficeDTO);

        assertEquals(NAME, medicalOffice.getName());
        assertEquals(CONTACT_DATA_DTO.getEmail(), medicalOffice.getContactData().getEmail());
        assertEquals(ADDRESS_DTO.getCity(), medicalOffice.getAddress().getCity());
        assertEquals(SCHEDULE_DTO.getMondayStart(), medicalOffice.getSchedule().getMondayStart());
        assertEquals(SPECIALTY_DTO.getName(), medicalOffice.getSpecialty().getName());
        assertEquals(APPOINTMENTS_LIST.size(), medicalOffice.getAppointments().size());
    }
}