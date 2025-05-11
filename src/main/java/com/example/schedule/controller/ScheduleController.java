package com.example.schedule.controller;

import com.example.schedule.dto.SchedulePostRequestDto;
import com.example.schedule.dto.SchedulePostResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.golbal.ScheduleStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
@RestController
@RequestMapping("schedules")
public class ScheduleController {
    //필드
    private final Map<Long, Schedule> scheduleList = new TreeMap<>();

    //생성자

    //기능
    @PostMapping
    public SchedulePostResponseDto createSchedule(@RequestBody SchedulePostRequestDto dto){
        //전달해줄 식별자생성
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        //전달해줄 상태 만들어주기
        ScheduleStatus status = ScheduleStatus.CREATE;
        //스캐줄객체생성
        Schedule createSchedule = new Schedule(scheduleId, dto.getDate(), dto.getTitle(), dto.getBody(),status);
        //list에 저장
        scheduleList.put(scheduleId, createSchedule);

        //리턴값은 항상 responseDto
        return new SchedulePostResponseDto(createSchedule);
    }
}
