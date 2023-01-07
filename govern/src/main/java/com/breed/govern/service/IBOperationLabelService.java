package com.breed.govern.service;

import com.breed.govern.dto.vo.OperationLabelListVo;
import com.breed.govern.dto.vo.SelectOperationLabelListVo;
import com.breed.govern.entity.BOperationLabel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 普通操作标签表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
public interface IBOperationLabelService extends IService<BOperationLabel> {
    int createOperationLabel(BOperationLabel data);

    int updateOperationLabel(BOperationLabel data);

    List<OperationLabelListVo> getOperationLabelList();

    BOperationLabel getOperationLabelById(long id);


    Integer deleteOperationLabel(long id);

    List<SelectOperationLabelListVo> selectOperationLabelListVo();

    Long getOlIdByContent();
}
