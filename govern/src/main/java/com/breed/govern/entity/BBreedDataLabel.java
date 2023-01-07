package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class BBreedDataLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型
     */
    @TableId(value = "dl_id", type = IdType.AUTO)
    private Integer dlId;
    /**
     * 父类id
     */
    private Integer parentId;

    /**
     * 名称
     */
    private String labelName;


}
