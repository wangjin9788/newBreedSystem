package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.servlet.annotation.HandlesTypes;

/**
 * <p>
 * 提示表
 * </p>
 *
 * @author 王进
 * @since 2022-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class BTipsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ti_id", type = IdType.AUTO)
    private Integer tiId;

    /**
     * 说明
     */
    private String explain;

    /**
     * 条件范围
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private int[] condition;

    /**
     * 采取措施
     */
    private String minMeasures;

    /**
     * 采取措施
     */
    private String maxMeasures;
    /**
     * 标识（0:气温  1:堆温 2:堆湿 3:ph  4:5:）
     */
    private Integer mark;

}
