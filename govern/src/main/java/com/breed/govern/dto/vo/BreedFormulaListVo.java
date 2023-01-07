package com.breed.govern.dto.vo;

import lombok.Data;

import java.util.List;

@Data
public class BreedFormulaListVo {
    private Long bfId;
    private List<BreedFormulaItem> formula;
    private Integer type;
    private Integer specs;
    private String markMethod;


}
