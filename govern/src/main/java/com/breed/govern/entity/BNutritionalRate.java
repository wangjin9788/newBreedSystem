package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 营养比例表
 * </p>
 *
 * @author 王进
 * @since 2022-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BNutritionalRate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "nr_id", type = IdType.AUTO)
    private Integer nrId;

    /**
     * 营养品名称
     */
    private String nutName;

    /**
     * 比例
     */
    private Double rate;


}
