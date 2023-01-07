package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 发酵结束表

 * </p>
 *
 * @author 王进
 * @since 2022-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BFermentTesting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发酵检测表id
     */
    @TableId(value = "ft_id", type = IdType.AUTO)
    private Long ftId;

    /**
     * 温度
     */
    private Double temp;

    /**
     * 刺激气味（0：没有  1有）
     */
    private Integer pungentOdor;

    /**
     * 发酵后图片
     */
    private String imgUrl;

    /**
     * ph
     */
    private Double ph;

    private  Long ffId;


}
