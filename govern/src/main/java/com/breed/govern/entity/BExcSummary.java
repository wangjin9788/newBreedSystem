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
 * 问题解决汇总表
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BExcSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题总结表
     */
    @TableId(value = "es_id", type = IdType.AUTO)
    private Long esId;

    /**
     * 正常操作id
     */
    private Long oId;
    /**
     * 操作表id（治疗经过果）
     */
    private Long eId;

    /**
     * 类型（0：未知  1：操作）
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 病害名称
     */
    private String diseaseName;
    /**
     * 病因
     */
    private String pathogeny;

    /**
     * 症状
     */
    private String symptom;

    /**
     * 治疗方法
     */
    private String treatment;

    /**
     * 最佳治疗方案
     */
    private String bestSolution;
    private long adId;


}
