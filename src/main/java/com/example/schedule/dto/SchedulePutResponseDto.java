package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class SchedulePutResponseDto {
    private Long id ;
    private LocalDate date;
    private String title;
    private String body;
    private String status;
}
