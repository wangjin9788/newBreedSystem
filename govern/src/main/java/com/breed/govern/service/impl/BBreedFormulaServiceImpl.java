package com.breed.govern.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breed.govern.dto.vo.BreedFormulaItem;
import com.breed.govern.dto.vo.BreedFormulaListVo;
import com.breed.govern.dto.vo.UpdateFeedFormulaInfo;
import com.breed.govern.entity.BBreedFormula;
import com.breed.govern.entity.BBreedFormulaLabel;
import com.breed.govern.entity.BBreedFormulaMake;
import com.breed.govern.mapper.BBreedFormulaLabelMapper;
import com.breed.govern.mapper.BBreedFormulaMakeMapper;
import com.breed.govern.mapper.BBreedFormulaMapper;
import com.breed.govern.service.IBBreedFormulaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 饲料配置表
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-22
 */
@Service
public class BBreedFormulaServiceImpl extends ServiceImpl<BBreedFormulaMapper, BBreedFormula> implements IBBreedFormulaService {

    @Resource
    private BBreedFormulaMakeMapper makeMapper;
    @Resource
    private BBreedFormulaLabelMapper labelMapper;

    @Override
    public List<BreedFormulaListVo> getFormulaList(Integer type) {
        // List<BFeedFormula> bFeedFormulas = mapper.selectList(null);
        return baseMapper.getFormulaList(type);
    }

    @Override
    public UpdateFeedFormulaInfo getFormulaInfoById(Integer id) {
        UpdateFeedFormulaInfo info = new UpdateFeedFormulaInfo();
        BBreedFormula data = baseMapper.selectById(id);
        List<String> list = new ArrayList<>();
        String json = JSON.toJSONString(data.getFormula());
        List<BreedFormulaItem> jsonList = JSON.parseArray(json, BreedFormulaItem.class);
        for (BreedFormulaItem item :
                jsonList) {

            String str = item.getName() + "/" + item.getRate() + "%";
            list.add(str);
        }
        info.setFormula(data.getFormula());
        info.setSpecs(data.getSpecs());
        info.setType(data.getType());
        info.setFormulaStr(list);
        BBreedFormulaMake make = makeMapper.selectById(data.getFmId());
        info.setMarkMethod(make.getMarkMethod());
        return info;
    }

    @Override
    public List<BBreedFormulaLabel> selectFormulaType() {
        return labelMapper.selectList(null);
    }
}
