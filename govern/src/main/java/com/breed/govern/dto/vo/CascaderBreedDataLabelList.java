package com.breed.govern.dto.vo;

import lombok.Data;

import java.util.List;

@Data
public class CascaderBreedDataLabelList {
    private Integer value;
    private  String label;
    private List<CascaderBreedDataLabelItem> children;
}

