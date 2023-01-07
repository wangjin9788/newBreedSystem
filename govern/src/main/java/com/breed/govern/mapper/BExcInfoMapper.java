package com.breed.govern.mapper;

import com.breed.govern.dto.vo.ExcInfoList;
import com.breed.govern.entity.BExcInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 异常信息表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface BExcInfoMapper extends BaseMapper<BExcInfo> {
   List<ExcInfoList> getExcInfoList();

   List<Long> getEIdByBId(@Param("idList") List<Long> idList);

   List<BExcInfo>getDayExcInfo();
}
