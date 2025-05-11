package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import com.example.schedule.golbal.ScheduleStatus;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class SchedulePostResponseDto {
    //속성
    private Long id ;
    private LocalDate date;
    private String title;
    private String body;
    private ScheduleStatus status;
    //생성자 컨트롤러의 메서드에 담을 생성자오버로딩 request에는 상태가없지만 response에는 상태가들어가야한다.
    public SchedulePostResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.date= schedule.getDate();
        this.title = schedule.getTitle();
        this.body = schedule.getBody();
        this.status = schedule.getStatus();
    }
}
