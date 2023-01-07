package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 普通操作标签表
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BOperationLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ol_id", type = IdType.AUTO)
    private Integer olId;


    /**
     * 标签内容
     */
    private String labelContent;


}
