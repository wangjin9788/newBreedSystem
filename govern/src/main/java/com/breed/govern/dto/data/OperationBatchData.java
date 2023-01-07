package com.breed.govern.dto.data;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OperationBatchData {

    private Long olId;
    private List<Long>list;
    private String operationContent;
    private LocalDateTime createTime;
}
