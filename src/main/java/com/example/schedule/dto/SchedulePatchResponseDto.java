package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class SchedulePatchResponseDto {
    private Long id ;
    private LocalDate date;
    private String title;
    private String body;
    public SchedulePatchResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.date = schedule.getDate();
        this.title = schedule.getTitle();
        this.body = schedule.getBody();

    }
}
