package com.breed.govern.mapper;

import com.breed.govern.dto.data.ExcOperationBatchData;
import com.breed.govern.dto.data.OperationBatchData;
import com.breed.govern.dto.vo.ExcOperationListVo;
import com.breed.govern.dto.vo.GetExcOperationInfo;
import com.breed.govern.entity.BExcOperation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 异常操作表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface BExcOperationMapper extends BaseMapper<BExcOperation> {

    List<ExcOperationListVo> getExcOperationList(@Param(value = "id")long id);

    String getOperationByeId(@Param(value = "eId")long eId);

    List<GetExcOperationInfo> getExcOperationByEid(@Param(value = "eId")long eId);

    void batchExcOperation(@Param(value = "batch") ExcOperationBatchData batch);

}
