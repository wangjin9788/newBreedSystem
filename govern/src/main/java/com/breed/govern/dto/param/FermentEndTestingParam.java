package com.breed.govern.dto.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class FermentEndTestingParam implements Serializable {


    private int status;

    /**
     * 温度
     */
    private Double temp;

    /**
     * 刺激气味（0：没有  1有）
     */
    private Integer pungentOdor;

    /**
     * 发酵后图片
     */
    private String imgUrl;

    /**
     * ph
     */
    private Double ph;

    private  Long ffId;

}
