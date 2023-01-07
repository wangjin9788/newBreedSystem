package com.breed.govern.dto.vo;

import lombok.Data;

import java.util.List;

@Data
public class RateItemVo {
    private String value;
    private String label;
    private List<RateItemVo> children;
}
