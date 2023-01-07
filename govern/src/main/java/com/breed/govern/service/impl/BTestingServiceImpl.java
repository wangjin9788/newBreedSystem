package com.breed.govern.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breed.govern.dto.vo.TestingListVo;
import com.breed.govern.entity.BExcInfo;
import com.breed.govern.entity.BTesting;
import com.breed.govern.mapper.BExcInfoMapper;
import com.breed.govern.mapper.BExcLabelMapper;
import com.breed.govern.mapper.BTestingMapper;
import com.breed.govern.service.IAdAnimalDiseaseService;
import com.breed.govern.service.IBExcSummaryService;
import com.breed.govern.service.IBTestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 检测表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Service
public class BTestingServiceImpl extends ServiceImpl<BTestingMapper, BTesting> implements IBTestingService {
    @Autowired
    private IBExcSummaryService summaryService;
    @Autowired
    private IAdAnimalDiseaseService diseaseService;

    @Resource
    private BExcInfoMapper excInfoMapper;

    @Resource
    private BExcLabelMapper excLabelMapper;

    @Override
    public int createTesting(BTesting data) {
        data.setType(0);
        if(data.getOId()>0){
            data.setType(1);
        }
        data.setCreateTime(LocalDateTime.now());
        data.setTestingTime(LocalDateTime.now());
        int dataCount = baseMapper.insert(data);
        if(dataCount>0){
            checkExcInfo(data);
        }
        return dataCount;
    }

    @Override
    public int updateTesting(BTesting data) {
        int byId = baseMapper.updateById(data);
        return byId;
    }

    @Override
    public List<TestingListVo> getTestingList(long bid) {
        List<TestingListVo> data = baseMapper.getTestingList(bid);
        for (TestingListVo vo: data) {
            if(vo.getSymptom()!=null){
                List<Integer> strings = JSONObject.parseArray(vo.getSymptom().toString(), Integer.class);
                vo.setSymptomName(baseMapper.getLabelInfo(strings));
            }
        }
        return data;
    }

    @Override
    public BTesting getTestingById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteTesting(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<BTesting> getDayTestingList() {
        return baseMapper.getDayTestingList();
    }

    private void checkExcInfo(BTesting data){
        String labelInfo=null;
        //获取对应的标签
        if(data.getSymptom()!=null) {
            //添加选择量
            excLabelMapper.batchExcLabelCount(data.getSymptom());
            List<Integer> strings = JSONObject.parseArray(data.getSymptom().toString(), Integer.class);
             labelInfo = baseMapper.getLabelInfo(strings);
        }
        //获取总结表信息
        long adId = summaryService.getSummaryByLabel(labelInfo);
        if(adId==0){
            //获取疾病信息表
            adId = diseaseService.getDiseaseExcInfo(labelInfo);
        }
        if(adId>0){
            BExcInfo excInfo = new BExcInfo();
            excInfo.setBId(data.getBId());
            excInfo.setLabelName(labelInfo);
            excInfo.setType(data.getType());
            excInfo.setCreateTime(LocalDateTime.now());
            excInfo.setAdId(adId);
            excInfo.setStatus(0);
            excInfo.setOId(data.getOId());
            excInfoMapper.insert(excInfo);
        }

    }
}
