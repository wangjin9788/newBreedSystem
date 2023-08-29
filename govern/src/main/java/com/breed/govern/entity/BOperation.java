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
 * 普通操作表
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作信息表id
     */
    @TableId(value = "o_id", type = IdType.AUTO)
    private Long oId;

    /**
     * 养殖表id
     */
    private Long bId;
    /**
     * 类型
     */
    private int type;
    /**
     * 内容
     */
    private String content;
    /**
     * 原因
     */
    private String reason;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
