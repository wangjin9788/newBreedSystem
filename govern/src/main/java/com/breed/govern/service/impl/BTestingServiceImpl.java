package com.breed.govern.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breed.govern.dto.vo.TestingListVo;
import com.breed.govern.entity.BTesting;
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


    @Override
    public int createTesting(BTesting data) {
        data.setCreateTime(LocalDateTime.now());
        data.setTestingTime(LocalDateTime.now());
        int dataCount = baseMapper.insert(data);
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
            if(vo.getSymptom()!=null) {
                List<Integer> strings = JSONObject.parseArray(vo.getSymptom().toString(), Integer.class);
                if (strings!=null&&strings.size()>0) {
                    vo.setSymptomName(baseMapper.getLabelInfo(strings));
                }
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

}
