package com.breed.govern.service;

import com.breed.govern.dto.vo.BreedFormulaListVo;
import com.breed.govern.dto.vo.UpdateFeedFormulaInfo;
import com.breed.govern.entity.BBreedFormula;
import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.entity.BBreedFormulaLabel;

import java.util.List;

/**
 * <p>
 * 饲料配置表
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-22
 */
public interface IBBreedFormulaService extends IService<BBreedFormula> {


    List<BreedFormulaListVo> getFormulaList(Integer type);

    UpdateFeedFormulaInfo getFormulaInfoById(Integer id);

    List<BBreedFormulaLabel> selectFormulaType();
}
