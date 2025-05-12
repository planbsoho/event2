package com.example.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SchedulePatchRequestDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String title;
    private String body;
}
