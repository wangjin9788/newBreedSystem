package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 检测病害标签表
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BExcLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签id
     */
    @TableId(value = "l_id", type = IdType.AUTO)
    private Integer lId;

    /**
     * 标签内容
     */
    private String labelName;
    /**
     * 选择量
     */
    private Long likeCount;

}
