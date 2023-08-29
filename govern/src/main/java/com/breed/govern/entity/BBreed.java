package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class BBreed implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 养殖表
     */
    @TableId(value = "b_id", type = IdType.AUTO)
    private Long bId;


    /**
     * 养殖模式
     */
    private Long bmId;
    /**
     * 类型(0:室内  1：室外)
     */
    private Integer type;

    /**
     * 投入时间
     */
    private String inputTime;

    /**
     * 投入重量
     */
    private Double inputWeight;
    /**
     * 养殖面积
     */
    private Double extent;
    /**
     * 标志（0：健康  1：一般  2：有问题）
     */
    private Integer breedMark;
    /**
     * 状态（0：养殖中 1：结束）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     *规格（1：小蚯蚓 2：中蚯蚓  3：大蚯蚓）
     */
    private int specifications;

}
