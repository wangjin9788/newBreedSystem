package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.breed.govern.dto.vo.BreedFormulaItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 饲料配置表

 * </p>
 *
 * @author 王进
 * @since 2022-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class BBreedFormula implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 饲料配置表
     */
    @TableId(value = "bf_id", type = IdType.AUTO)
    private Integer bfId;

    /**
     * 配方
     */

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<BreedFormulaItem> formula;

    /**
     * 类型（0:基料  1：饲料）
     */
    private Integer type;

    /**
     * 范围（0：所有 1：幼蚓 2：中蚓 3：大蚓）
     */
    private Integer specs;
    /**
     * 制作id
     */
    private String fmId;

}
