package com.example.schedule.dto;

import lombok.Getter;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
@Getter
public class ScheduleUpdateRequestDto {
    @NotBlank
    private Long id ;
    @NotBlank(message = "제목은 필수값입니다")
    private String title;
    @NotBlank(message = "본문은 필수값입니다")
    private String body;
}
