package com.breed.govern.dto.vo;


import lombok.Data;

@Data
public class BreedModelListVo {
    /**
     * 模型id
     */
    private Integer bmId;
    /**
     * 模型
     */
    private String breedModel;

    /**
     * 基料内容
     */
    private String fermentInfo;
}
