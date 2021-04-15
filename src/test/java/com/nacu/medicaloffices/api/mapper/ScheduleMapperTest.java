package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.ScheduleDTO;
import com.nacu.medicaloffices.domain.Schedule;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScheduleMapperTest {

    private final LocalTime MONDAY_START = LocalTime.of(8, 0);
    private final LocalTime MONDAY_END = LocalTime.of(18, 30);

    private final ScheduleMapper scheduleMapper = ScheduleMapper.INSTANCE;

    @Test
    void scheduleToScheduleDTO() {
        Schedule schedule = Schedule.builder().mondayStart(MONDAY_START).mondayEnd(MONDAY_END).build();
        ScheduleDTO scheduleDTO = scheduleMapper.scheduleToScheduleDTO(schedule);

        assertEquals(MONDAY_START, scheduleDTO.getMondayStart());
        assertEquals(MONDAY_END, scheduleDTO.getMondayEnd());
    }

    @Test
    void scheduleDTOtoSchedule() {
        ScheduleDTO scheduleDTO = ScheduleDTO.builder().mondayStart(MONDAY_START).mondayEnd(MONDAY_END).build();
        Schedule schedule = scheduleMapper.scheduleDTOtoSchedule(scheduleDTO);

        assertEquals(MONDAY_START, schedule.getMondayStart());
        assertEquals(MONDAY_END, schedule.getMondayEnd());
    }
}