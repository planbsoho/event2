package com.example.schedule.controller;

import com.example.schedule.dto.*;
import com.example.schedule.entity.Schedule;
import com.example.schedule.golbal.ScheduleStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    //필드
    private final Map<Long, Schedule> scheduleList = new TreeMap<>();

    //생성자

    //기능
    //포스트 생성
    @PostMapping
    public SchedulePostResponseDto createSchedule(@RequestBody SchedulePostRequestDto dto) {
        //전달해줄 식별자생성
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        //전달해줄 상태 만들어주기
        ScheduleStatus status = ScheduleStatus.CREATE;
        //스캐줄객체생성
        Schedule createSchedule = new Schedule(scheduleId, dto.getDate(), dto.getTitle(), dto.getBody() );
        createSchedule.markAsCreate();
        //list에 저장
        scheduleList.put(scheduleId, createSchedule);

        //리턴값은 항상 responseDto
        return new SchedulePostResponseDto(createSchedule);
    }


//    @GetMapping("/id")
//    public ScheduleGetResponseDto checkSchedule1(@PathVariable Long id) {
//        Schedule schedule = scheduleList.get(id);
//        //저장된 schedule 객체의 이넘타입 변경해서 보내주기 이 기능이 컨트롤러에 있어야할까 DTO에 있어야할까
//        //DTO는 단순히 데이터를 옮기는객체이다 컨트롤러나 서비스에서 변경이맞다.
//        schedule.setStatus(ScheduleStatus.SUCCESS);
//        return new ScheduleGetResponseDto(schedule);
//    }  무분별한 세터는 지양하자
    //Get조회 삭제시 널일경우 500이아닌 404가뜨도록 예외처리
    @GetMapping("/{id}")
    public ScheduleGetResponseDto checkSchedule(
            @PathVariable Long id
            ) {
        Schedule schedule = scheduleList.get(id);
        if( schedule == null){
            throw new NoSuchElementException(id + "스캐줄이 존재하지 않습니다.");
        }
        schedule.markAsSuccess(); // 의미가 명확해짐
        return new ScheduleGetResponseDto(schedule);
    }

    //수정메서드
    @PutMapping("/{id}")
    public ScheduleUpdateResponseDto updateScheduleBYId(
            @PathVariable Long id,
            @RequestBody ScheduleUpdateRequestDto dto
            ){
        Schedule schedule = scheduleList.get(id);
        schedule.updateSchedule(dto);
        schedule.markAsComplete();
        return new ScheduleUpdateResponseDto(schedule);
    }
    @DeleteMapping("/{id}")
    public ScheduleDeleteResponseDto deleteSchedule(@PathVariable Long id){
        scheduleList.remove(id);
        return new ScheduleDeleteResponseDto(id);
    }
}
