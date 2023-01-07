package com.breed.govern.dto.vo;

import lombok.Data;

import java.util.List;

@Data
public class UpdateFeedFormulaInfo {
    private List<String> formulaStr;
    private List<BreedFormulaItem> formula;
    private Integer type;
    private Integer specs;
    private String markMethod;
}
