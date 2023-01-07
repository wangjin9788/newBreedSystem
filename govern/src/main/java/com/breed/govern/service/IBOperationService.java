package com.breed.govern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.dto.data.OperationBatchData;
import com.breed.govern.dto.vo.OperationListVo;
import com.breed.govern.dto.vo.SelectOperationList;
import com.breed.govern.entity.BOperation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 普通操作表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
public interface IBOperationService extends IService<BOperation> {
    int createOperation(BOperation data);

    int updateOperation(BOperation data);

    List<OperationListVo> getOperationList(long bid);

    BOperation getOperationById(long id);


    Integer deleteOperation(long id);

    List<SelectOperationList>selectOperationList();

    void batchOperation( OperationBatchData batch);
}
