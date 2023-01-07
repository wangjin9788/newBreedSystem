package com.breed.govern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 动物病理信息表
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdAnimalDisease implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 动物病理信息表
     */
    @TableId(value = "ad_id", type = IdType.AUTO)
    private Long adId;

    /**
     * 病害性质表
     */
    private Long nId;

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

    private String imgUrl;


}
