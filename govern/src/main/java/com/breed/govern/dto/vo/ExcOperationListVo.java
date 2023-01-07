package com.breed.govern.dto.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExcOperationListVo implements Serializable {
    private long eoId;
    /**
     * 症状
     */
    private String symptom;
    //操作内容
    private String operation;
    //评价（0：较差  1：一般 2：良好）
    private int effect;
    private String createTime;
}
