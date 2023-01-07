package com.breed.govern.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.breed.govern.dto.param.PayDataParam;
import com.breed.govern.entity.ExpPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
public interface ExpPayMapper extends BaseMapper<ExpPay> {

    List<PayDataParam> getPayList(Page<PayDataParam> page, @Param("time") String time);
}
