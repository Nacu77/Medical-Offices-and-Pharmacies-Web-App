package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.ScheduleDTO;
import com.nacu.medicaloffices.domain.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
    ScheduleDTO scheduleToScheduleDTO(Schedule schedule);
    Schedule scheduleDTOtoSchedule(ScheduleDTO scheduleDTO);
}
