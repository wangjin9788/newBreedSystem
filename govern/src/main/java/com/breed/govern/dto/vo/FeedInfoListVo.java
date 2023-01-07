package com.breed.govern.dto.vo;

import lombok.Data;

@Data
public class FeedInfoListVo {
    /**
     * 饲料id
     */
    private long fid;
    /**
     * 饲料类型
     */
    private int mark;
    /**
     * 饲料内容
     */
    private String content;
    /**
     * 额外饲料内容
     */
    private String extContent;
}
