package com.breed.govern.mapper;

import com.breed.govern.dto.vo.TestingListVo;
import com.breed.govern.entity.BTesting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 检测表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface BTestingMapper extends BaseMapper<BTesting> {
    List<TestingListVo> getTestingList(@Param(value = "bid") long bid);

    String getLabelInfo(@Param(value = "list") List<Integer> list);

    List<BTesting>getDayTestingList();
}
