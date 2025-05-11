package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class ScheduleUpdateRequestDto {
    private Long id ;  //하나의 date에 두가지일정인경우 id로 구분.
//    private LocalDate date; 날짜는 수정할필요없는데 왜받아
    private String title;
    private String body;
}
