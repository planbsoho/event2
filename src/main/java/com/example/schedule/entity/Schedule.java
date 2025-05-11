package com.example.schedule.entity;

import com.example.schedule.golbal.ScheduleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class Schedule {
    //필드
    private Long id ;
    private LocalDate date;
    private String title;
    private String body;
    private ScheduleStatus status;//일정의 상태 생성됨, 조회됨, 삭제됨.같은 enum으로?



}
