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
 * 异常操作表
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BExcOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 异常操作表
     */
    @TableId(value = "eo_id", type = IdType.AUTO)
    private Long eoId;

    /**
     * 异常信息
     */
    private Long eId;

    /**
     * 操作内容
     */
    private String operation;

    /**
     * 效果（0：较差  1：一般 2：良好）
     */
    private Integer effect;

    private LocalDateTime createTime;


}
