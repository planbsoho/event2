package com.example.schedule.dto;

import lombok.Getter;


import java.time.LocalDate;
@Getter
public class SchedulePutRequestDto {
    private Long id;
    private LocalDate date;
}
