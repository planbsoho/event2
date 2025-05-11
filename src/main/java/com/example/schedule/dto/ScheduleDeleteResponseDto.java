package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleDeleteResponseDto {
    private LocalDate date;
    private String status;
}
