package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import com.example.schedule.golbal.ScheduleStatus;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleDeleteResponseDto {
    //속성
    private ScheduleStatus status;
    private String message;
    private Long id;
    //생성자
    public ScheduleDeleteResponseDto(Long id){
        this.id = id;
        this.message = "삭제되었습니다.";
        this.status = ScheduleStatus.DELETE;
    }
    //기능
}
