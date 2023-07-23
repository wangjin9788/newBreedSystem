package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 检测表
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "b_testing",autoResultMap = true)
public class BTesting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 检测表id
     */
    @TableId(value = "tid", type = IdType.AUTO)
    private Long tid;
    /**
     * 正常操作表id
     */
    private Long bId;
    /**
     * 正常操作表id
     */
    private long oId;

    /**
     * 天气
     */
    private String weather;

    /**
     * 温度
     */
    private Double temperature;

    /**
     * ph
     */
    private Double ph;

    /**
     * 养殖温度
     */
    private Double breedTemperature;

    /**
     * 养殖基料湿度
     */
    private Double breedHumidity;

    /**
     * 检测时间
     */
    private LocalDateTime testingTime;

    /**
     * 是否有病蚓（0：没有  1：有）
     */
    private Integer disease;

    /**
     * 症状标签（l_id）
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<Integer> symptom;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 类型（0：未知  1：操作不当）
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
