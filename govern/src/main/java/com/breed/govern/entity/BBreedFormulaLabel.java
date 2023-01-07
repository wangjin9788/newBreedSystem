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
 * @since 2022-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BBreedFormulaLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fl_id", type = IdType.AUTO)
    private Integer flId;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 标签名称
     */
    private String labelName;


}
