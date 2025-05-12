package com.example.schedule.controller;

import com.example.schedule.dto.*;
import com.example.schedule.entity.Schedule;
import com.example.schedule.golbal.ScheduleStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SchedulePostResponseDto> createSchedule(@RequestBody SchedulePostRequestDto dto) {
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
        return new ResponseEntity<>(new SchedulePostResponseDto(createSchedule), HttpStatus.CREATED);
    }


    //private final Map<Long, Schedule> scheduleList = new TreeMap<>();
    @GetMapping
    public ResponseEntity<List<ScheduleGetResponseDto>> checkAllSchedule(){
        List<ScheduleGetResponseDto> allList = new ArrayList<>();
        for(Schedule schedule : scheduleList.values()){
            ScheduleGetResponseDto responseDto = new ScheduleGetResponseDto(schedule);
            allList.add(responseDto);
        }
        return new ResponseEntity<>(allList,HttpStatus.CREATED);
    }
    //Get조회 삭제시 널일경우 500이아닌 404가뜨도록 예외처리
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleGetResponseDto> checkSchedule(
            @PathVariable Long id
            ) {
        Schedule schedule = scheduleList.get(id);
        if( schedule == null){
//            throw new NoSuchElementException(id + "스캐줄이 존재하지 않습니다.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        schedule.markAsSuccess(); // 의미가 명확해짐
        return new ResponseEntity<>(new ScheduleGetResponseDto(schedule),HttpStatus.OK);
    }

    //수정메서드
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleUpdateResponseDto> updateScheduleBYId(
            @PathVariable Long id,
            @RequestBody ScheduleUpdateRequestDto dto
            ){
        Schedule schedule = scheduleList.get(id);
        if( schedule == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if( dto.getTitle() == null || dto.getBody() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        schedule.updateSchedule(dto);
        schedule.markAsComplete();
        return new ResponseEntity<>(new ScheduleUpdateResponseDto(schedule),HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<SchedulePatchResponseDto>(
//            @PathVariable Long id;
//            @RequestBody SchedulePatchRequestDto dto
//            ){
//        Schedule schedule = scheduleList.get(id);
//        if ( dto.getTitle() == null || dto.getBody() != null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        schedule.updateScheduleTitle(dto);
//    }
//    return new ResponseEntity<>(SchedulePatchResponseDto(dto))

    //제목만수정
    @PatchMapping("/{id}")
    public ResponseEntity<SchedulePatchResponseDto> updateTitle(
            @PathVariable Long id,
            @RequestBody SchedulePatchRequestDto dto
    ){
        Schedule schedule = scheduleList.get(id);
        if (schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if ( dto.getTitle() == null || dto.getBody() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        schedule.updateScheduleTitle(dto);
        return new ResponseEntity<>(new SchedulePatchResponseDto(schedule), HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ScheduleDeleteResponseDto deleteSchedule1(@PathVariable Long id){
//        scheduleList.remove(id);
//        return new ScheduleDeleteResponseDto(id);
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule( @PathVariable Long id){
        if( scheduleList.containsKey(id)){
            scheduleList.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
