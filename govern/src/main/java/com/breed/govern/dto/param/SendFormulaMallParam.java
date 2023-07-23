package com.breed.govern.dto.param;

import lombok.Data;

import java.util.List;

@Data
public class SendFormulaMallParam {
    private Long weight;
    private String unit;
    private List<String> results;
    private List<String> formulaStr;
    private Integer radio;
    private String markMethod;
    private String weightUnit;
    private int mark;
}
