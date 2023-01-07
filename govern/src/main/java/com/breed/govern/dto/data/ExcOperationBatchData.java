package com.breed.govern.dto.data;

import lombok.Data;

import java.util.List;

@Data
public class ExcOperationBatchData {
    private List<Long> list;
    private String operation;

}
