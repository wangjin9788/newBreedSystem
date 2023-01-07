package com.breed.govern.dto.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FermentListVo {
    private long ffId;
    private String fermentInfo;
    private int fermentDay;
    private LocalDateTime fermentTime;
    private int status;
    private String createImage;
}
