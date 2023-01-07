package com.breed.govern.dto.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class NutritionClaParam implements Serializable {
    //多少千克
    private List<NutritionClaItemParam> domains;
    //介质
    private List<NutritionClaItemParam> mediums;
    //比例
    private List<NutritionClaArrParam> rates;
    //结果
    private List<NutritionClaItemParam> results;
    //操作
    private Integer oper;
    //养殖表id
    private List<Long> checkedCities;
}
