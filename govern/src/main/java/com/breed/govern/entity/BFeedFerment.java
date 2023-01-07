package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 发酵表
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BFeedFerment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发酵饲料id
     */
    @TableId(value = "ff_id", type = IdType.AUTO)
    private Integer ffId;

    /**
     * 发酵内容
     */
    private String fermentInfo;

    /**
     * 发酵时间
     */
    private LocalDateTime fermentTime;

    /**
     * 状态（0：发酵中 1：发酵结束）
     */
    private Integer status;
    /**
     * 发酵前图片
     */
    private String createImage;



}
