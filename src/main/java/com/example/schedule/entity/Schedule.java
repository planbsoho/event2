package com.example.schedule.entity;

import com.example.schedule.dto.ScheduleUpdateRequestDto;
import com.example.schedule.golbal.ScheduleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class Schedule {
    //필드
    private Long id ;
    private LocalDate date;
    private String title;
    private String body;
    private ScheduleStatus status;
    private LocalDate updateDate; //수정한날짜
    //생성자
    //생성할때 사용하는 updateDate가 없는생성ㅇ자
    public Schedule(Long id, LocalDate date, String title, String body){
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }

    //기능
//    public void setStatus(ScheduleStatus status){
//        this.status = status;
//    } 무분별한세터금지  아래는 알기쉬운 비즈니스로직이며 setter처럼 무제한접근권한이 아닌 success만 쓴다. 설계가 명확하고 안정적이다.
    public void markAsSuccess() {
        this.status = ScheduleStatus.SUCCESS;
    }
    public void markAsCreate(){
        this.status = ScheduleStatus.CREATE;
    }
    public void markAsComplete(){
        this.status = ScheduleStatus.COMPLETE;
    }
    //수정시 수정시각추가와 내용 덮어쓰기메서드
    public void updateSchedule(ScheduleUpdateRequestDto dto){
        this.title = dto.getTitle();
        this.body = dto.getBody();
        this.updateDate = LocalDate.now();
    }

}
