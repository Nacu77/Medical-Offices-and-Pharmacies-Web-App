package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
public class ScheduleDTO {

    private Long id;

    private LocalTime mondayStart;
    private LocalTime mondayEnd;

    private LocalTime tuesdayStart;
    private LocalTime tuesdayEnd;

    private LocalTime wednesdayStart;
    private LocalTime wednesdayEnd;

    private LocalTime thursdayStart;
    private LocalTime thursdayEnd;

    private LocalTime fridayStart;
    private LocalTime fridayEnd;

    private LocalTime saturdayStart;
    private LocalTime saturdayEnd;

    private LocalTime sundayStart;
    private LocalTime sundayEnd;

    @Builder
    public ScheduleDTO(Long id, LocalTime mondayStart, LocalTime mondayEnd, LocalTime tuesdayStart, LocalTime tuesdayEnd, LocalTime wednesdayStart, LocalTime wednesdayEnd, LocalTime thursdayStart, LocalTime thursdayEnd, LocalTime fridayStart, LocalTime fridayEnd, LocalTime saturdayStart, LocalTime saturdayEnd, LocalTime sundayStart, LocalTime sundayEnd) {
        this.id = id;
        this.mondayStart = mondayStart;
        this.mondayEnd = mondayEnd;
        this.tuesdayStart = tuesdayStart;
        this.tuesdayEnd = tuesdayEnd;
        this.wednesdayStart = wednesdayStart;
        this.wednesdayEnd = wednesdayEnd;
        this.thursdayStart = thursdayStart;
        this.thursdayEnd = thursdayEnd;
        this.fridayStart = fridayStart;
        this.fridayEnd = fridayEnd;
        this.saturdayStart = saturdayStart;
        this.saturdayEnd = saturdayEnd;
        this.sundayStart = sundayStart;
        this.sundayEnd = sundayEnd;
    }
}
