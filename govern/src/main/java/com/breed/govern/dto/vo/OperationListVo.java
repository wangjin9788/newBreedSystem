package com.breed.govern.dto.vo;

import lombok.Data;

@Data
public class OperationListVo {

    private long oid;
    private int type;
    private String reason;
    private String content;
    private String createTime;
}
