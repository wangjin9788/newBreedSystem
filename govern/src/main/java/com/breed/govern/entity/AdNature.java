package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 病害性质
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdNature implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 病害性质
     */
    @TableId(value = "n_id", type = IdType.AUTO)
    private Long nId;

    /**
     * 性质
     */
    private String nature;

    /**
     * 说明
     */

    private String natureExplain;


}
