package com.breed.govern.dto.vo;

import lombok.Data;

@Data
public class ExcInfoList {
    private long eId;
    private long bId;
    //病情描述
    private String labelInfo;
    //操作内容
    private String content;
    //病害名称
    private  String diseaseName;
    //引起原因
    private String pathogeny;
    //症状
    private String symptom;
    //治疗方案
    private String treatment;
    //治疗状态
    private int status;
    //创建时间
    private String createTime;



}
