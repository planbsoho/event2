package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import com.example.schedule.golbal.ScheduleStatus;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class ScheduleGetResponseDto {
    /// 기능
    private Long id ;
    private LocalDate date;
    private String title;
    private String body;
    private ScheduleStatus status;

    //생성자
    public ScheduleGetResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.date = schedule.getDate();
        this.title = schedule.getTitle();
        this.body = schedule.getBody();
        this.status= schedule.getStatus();
    }
}
