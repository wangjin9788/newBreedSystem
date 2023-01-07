package com.breed.govern.mapper;

import com.breed.govern.entity.BExcLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 检测病害标签表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface BExcLabelMapper extends BaseMapper<BExcLabel> {
   void batchExcLabelCount(@Param(value = "list") List<Integer> list);
}
