package com.breed.govern.dto.vo;

import lombok.Data;

@Data
public class AdNatureListVo {
    private Long adId;

    /**
     * 病害性质
     */
    private String nature;

    /**
     * 病害名称
     */
    private String diseaseName;

    /**
     * 病因
     */
    private String pathogeny;

    /**
     * 症状
     */
    private String symptom;

    /**
     * 治疗方法
     */
    private String treatment;

    private  String imgUrl;
}
