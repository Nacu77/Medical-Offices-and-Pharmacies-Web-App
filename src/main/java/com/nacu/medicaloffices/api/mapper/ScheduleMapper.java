package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.ScheduleDTO;
import com.nacu.medicaloffices.domain.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleDTO scheduleToScheduleDTO(Schedule schedule);
    Schedule scheduleDTOtoSchedule(ScheduleDTO scheduleDTO);
}
