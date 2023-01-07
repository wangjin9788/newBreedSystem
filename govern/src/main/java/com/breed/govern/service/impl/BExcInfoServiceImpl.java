package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breed.govern.dto.vo.ExcInfoList;
import com.breed.govern.entity.AdAnimalDisease;
import com.breed.govern.entity.BExcInfo;
import com.breed.govern.entity.BExcSummary;
import com.breed.govern.mapper.AdAnimalDiseaseMapper;
import com.breed.govern.mapper.BExcInfoMapper;
import com.breed.govern.mapper.BExcOperationMapper;
import com.breed.govern.mapper.BExcSummaryMapper;
import com.breed.govern.service.IBExcInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 异常信息表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Service
public class BExcInfoServiceImpl extends ServiceImpl<BExcInfoMapper, BExcInfo> implements IBExcInfoService {

    @Resource
    private AdAnimalDiseaseMapper diseaseMapper;

    @Resource
    private BExcOperationMapper operationMapper;

    @Resource
    private BExcSummaryMapper summaryMapper;

    @Override
    public List<ExcInfoList> getExcInfoList() {
        List<ExcInfoList> excInfoList = baseMapper.getExcInfoList();
        return excInfoList;
    }

    @Override
    public int updateStatusAndInsertSummary(Integer id) {
        BExcInfo excInfo=baseMapper.selectById(id);
        if(excInfo!=null){
            excInfo.setStatus(1);
            int byId = baseMapper.updateById(excInfo);
            BExcSummary summary = new BExcSummary();
            summary.setOId(excInfo.getOId());
            summary.setEId(excInfo.getEId());
            summary.setType(excInfo.getType());
            summary.setCreateTime(LocalDateTime.now());
            AdAnimalDisease dise = diseaseMapper.selectById(excInfo.getAdId());
            summary.setDiseaseName(dise.getDiseaseName());
            summary.setPathogeny(dise.getPathogeny());
            summary.setSymptom(dise.getSymptom());
            summary.setAdId(dise.getAdId());
            summary.setTreatment(dise.getTreatment());
            String operation = operationMapper.getOperationByeId(excInfo.getEId());
            summary.setBestSolution(operation);
            summaryMapper.insert(summary);
            return byId;
        }
        return 0;
    }

    @Override
    public List<Long> getEIdByBId(List<Long> idList) {
        return baseMapper.getEIdByBId(idList);
    }

    @Override
    public List<BExcInfo> getDayExcInfo() {
        return baseMapper.getDayExcInfo();
    }
}
