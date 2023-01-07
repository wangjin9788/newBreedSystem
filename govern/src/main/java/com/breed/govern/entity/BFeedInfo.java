package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BFeedInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 饲料信息表
     */
    @TableId(value = "f_id", type = IdType.AUTO)
    private Long fId;

    /**
     * 发酵id
     */
    private Long ffId;

    /**
     * 标志（0：基料 1：添加饲料）
     */
    private Integer mark;

    /**
     * 饲料内容
     */
    private String content;

    /**
     * 额外添加内容
     */
    private String extContent;

    /**
     * 创建时间
     */
    private String createTime;

}
