package com.breed.govern.mapper;

import com.breed.govern.dto.vo.OperationLabelListVo;
import com.breed.govern.dto.vo.SelectOperationLabelListVo;
import com.breed.govern.entity.BOperationLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 普通操作标签表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
public interface BOperationLabelMapper extends BaseMapper<BOperationLabel> {
    List<OperationLabelListVo> getOperationLabelList();

    List<SelectOperationLabelListVo> SelectOperationLabelListVo();

    Long getOlIdByContent();
}
