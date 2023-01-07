package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 养殖资料
 * </p>
 *
 * @author 王进
 * @since 2022-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BBreedData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bi_id", type = IdType.AUTO)
    private Long biId;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签
     */
    private Integer dlId;




}
