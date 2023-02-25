package com.breed.govern.dto.vo;

import lombok.Data;

@Data
public class BreedDataInfo {

   private int[] idList;

    private Long biId;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签
     */
    private Integer dlId;
    private Integer parentId;
}
