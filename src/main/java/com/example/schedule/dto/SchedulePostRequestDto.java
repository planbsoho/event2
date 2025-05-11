package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class SchedulePostRequestDto {
    private LocalDate date;
    private String title;
    private String body;
}
