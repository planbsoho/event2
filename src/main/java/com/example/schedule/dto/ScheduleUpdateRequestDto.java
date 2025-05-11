package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class ScheduleUpdateRequestDto {
    private Long id ;  //하나의 date에 두가지일정인경우 id로 구분.
    private LocalDate date;
    private String title;
    private String body;
}
