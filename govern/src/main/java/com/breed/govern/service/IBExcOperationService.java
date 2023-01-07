package com.breed.govern.service;

import com.breed.govern.dto.data.ExcOperationBatchData;
import com.breed.govern.dto.vo.ExcOperationListVo;
import com.breed.govern.dto.vo.GetExcOperationInfo;
import com.breed.govern.dto.vo.OperationListVo;
import com.breed.govern.dto.vo.SelectOperationList;
import com.breed.govern.entity.BExcOperation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.entity.BOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 异常操作表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface IBExcOperationService extends IService<BExcOperation> {
    int createExcOperation(BExcOperation data);

    int updateExcOperation(BExcOperation data);

    List<ExcOperationListVo> getExcOperationList(long id);

    BExcOperation getExcOperationById(long id);

    List<GetExcOperationInfo> getExcOperationByEid( Integer id);

    Integer deleteExcOperation(long id);

    String getOperationByeId(long eId);

    void batchExcOperation( ExcOperationBatchData batch);

}
