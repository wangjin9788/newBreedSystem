package com.breed.govern.mapper;

import com.breed.govern.dto.data.OperationBatchData;
import com.breed.govern.dto.vo.OperationListVo;
import com.breed.govern.dto.vo.SelectOperationList;
import com.breed.govern.entity.BOperation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 普通操作表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
public interface BOperationMapper extends BaseMapper<BOperation> {

    List<OperationListVo> getOperationList(@Param(value = "bid") long bid);

    List<SelectOperationList>selectOperationList();

    void batchOperation(@Param(value = "batch") OperationBatchData batch);
}
