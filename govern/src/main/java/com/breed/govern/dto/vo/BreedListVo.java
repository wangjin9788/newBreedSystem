package com.breed.govern.dto.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BreedListVo {
    private long bid;
    //养殖类型(0:室内  1：室外)
    private int type;
    //养殖方式
    private String breedModel;
    //养殖面积
    private double extent;
    //投入重量
    private float inputWeight;
    //状态
    private int status;
    //健康标志
    private int breedMark;
    //投入时间
    private String inputTime;
    //规格
    private int  specifications;
    //养殖环境
    private int pattern;
}
