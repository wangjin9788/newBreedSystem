package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breed.govern.dto.vo.BreedDataInfo;
import com.breed.govern.dto.vo.BreedDataList;
import com.breed.govern.dto.vo.CascaderBreedDataLabelItem;
import com.breed.govern.dto.vo.CascaderBreedDataLabelList;
import com.breed.govern.entity.BBreedData;
import com.breed.govern.entity.BBreedDataLabel;
import com.breed.govern.mapper.BBreedDataLabelMapper;
import com.breed.govern.mapper.BBreedDataMapper;
import com.breed.govern.service.IBBreedDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 养殖资料 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-25
 */
@Service
@Api("养殖资料")
public class BBreedDataServiceImpl extends ServiceImpl<BBreedDataMapper, BBreedData> implements IBBreedDataService {

    @Resource
    private BBreedDataLabelMapper labelMapper;
    @Override
    public  List<BreedDataList> getBreedDataList(Integer menuNumber, String searchName, Integer dlId) {
        return baseMapper.getBreedDataList(menuNumber,searchName,dlId);
    }

    @Override
    public Integer createBreedData(BBreedData data) {
        return baseMapper.insert(data);
    }

    @Override
    public Integer updateBreedData(BBreedData data) {
        return baseMapper.updateById(data);
    }

    @Override
    public Integer deleteBreedData(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public BreedDataInfo getBreedDataById(Integer id) {
        BreedDataInfo info = baseMapper.getBreedDataById(id);
        info.setIdList(new int[]{info.getParentId(),info.getDlId()});
        return info;
    }

    @Override
    public List<BBreedDataLabel> selectBreedDataLabelInfo(Integer dlId) {
        List<BBreedDataLabel> list=new ArrayList<>();
        BBreedDataLabel all= new BBreedDataLabel();
        all.setDlId(0);
        all.setLabelName("ALL");
        list.add(all);
        QueryWrapper<BBreedDataLabel> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("parent_id",dlId);
        list.addAll(labelMapper.selectList(queryWrapper));
        return list;
    }

    @Override
    public List<CascaderBreedDataLabelList> cascaderBreedDataLabelInfo() {

        List<BBreedDataLabel> labelData = labelMapper.selectList(null);
        List<BBreedDataLabel> itemList = labelData.stream().filter(a -> {
            return a.getParentId() > 0;
        }).collect(Collectors.toList());
        List<CascaderBreedDataLabelList> arr= new ArrayList<>();
        for (BBreedDataLabel info: labelData) {
            if(info.getParentId()==0){
                CascaderBreedDataLabelList label =new CascaderBreedDataLabelList();
                label.setValue(info.getDlId());
                label.setLabel(info.getLabelName());
                List<CascaderBreedDataLabelItem> items= new ArrayList<>();
                for (BBreedDataLabel cl: itemList) {
                    if(cl.getParentId()==info.getDlId()){
                        CascaderBreedDataLabelItem i=new CascaderBreedDataLabelItem();
                        i.setValue(cl.getDlId());
                        i.setLabel(cl.getLabelName());
                        items.add(i);

                    }
                }
                label.setChildren(items);
                arr.add(label);
            }
        }
        return arr;
    }
}
