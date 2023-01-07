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
 * 产出记录
 * </p>
 *
 * @author 王进
 * @since 2022-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BBreedOut implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bo_id", type = IdType.AUTO)
    private Long boId;

    private Double outPut;

    /**
     * 产出时间
     */
    private LocalDateTime outTime;

    /**
     * 养殖表
     */
    private Long bId;


}
