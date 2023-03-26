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
 *
 * </p>
 *
 * @author 王进
 * @since 2023-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BFermentDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发酵记录id
     */
    @TableId(value = "fd_id", type = IdType.AUTO)
    private Long fdId;

    /**
     * 堆温度
     */
    private Float heapHead;

    /**
     * 气温
     */
    private Float head;

    /**
     * 时间
     */
    private LocalDateTime createTime;


    private Long ffId;
}
