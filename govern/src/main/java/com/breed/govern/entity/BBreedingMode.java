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
 * @since 2022-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BBreedingMode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖模型表
     */
    @TableId(value = "bm_id", type = IdType.AUTO)
    private Integer bmId;

    /**
     * 饲料配置表id
     */
    private Integer fId;

    /**
     * 模型
     */
    private String breedModel;


}
