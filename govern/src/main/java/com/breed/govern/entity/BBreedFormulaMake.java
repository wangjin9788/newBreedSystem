package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 配方制作

 * </p>
 *
 * @author 王进
 * @since 2022-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BBreedFormulaMake implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fm_id", type = IdType.AUTO)
    private Integer fmId;

    /**
     * 制作方法
     */
    private String markMethod;

    /**
     * 类型（0:基料  1：饲料，2：催产药）
     */
    private Integer type;


}
