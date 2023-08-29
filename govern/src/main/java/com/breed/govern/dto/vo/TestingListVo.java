package com.breed.govern.dto.vo;

import com.mysql.cj.xdevapi.JsonArray;
import lombok.Data;

import java.util.List;

@Data
public class TestingListVo {
   private long tid;
   //天气
   private String weather;
   //温度
    private double temperature;
    //ph
    private double ph;
    //养殖温度
    private double breedTemperature;
    //养殖箱湿度
    private double breedHumidity;
    //检测时间
    private String testingTime;
    //病害标签
    private int disease;
    //症状标签
    private String symptom;
    //病蚓图片
    private String imgUrl;
    //症状信息
    private String symptomName;

}
