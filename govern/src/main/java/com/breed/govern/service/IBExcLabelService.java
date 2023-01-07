package com.breed.govern.service;

import com.breed.govern.dto.vo.BreedModelListVo;
import com.breed.govern.dto.vo.SelectBreedModelListVo;
import com.breed.govern.dto.vo.SelectExcLabelList;
import com.breed.govern.entity.BExcLabel;
import com.breed.govern.entity.BExcLabel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 检测病害标签表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface IBExcLabelService extends IService<BExcLabel> {
    int createExcLabel(BExcLabel model);

    int updateExcLabel(BExcLabel model);

    Integer deleteExcLabel(long id);


    BExcLabel getExcLabelById( Integer id);

    List<BExcLabel> getExcLabelList();

    List<SelectExcLabelList> SelectExcLabelList();
}
