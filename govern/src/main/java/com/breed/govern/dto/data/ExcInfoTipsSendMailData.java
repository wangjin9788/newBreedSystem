package com.breed.govern.dto.data;

import lombok.Data;

import java.util.List;

@Data
public class ExcInfoTipsSendMailData {
    //养殖编号
    private List<Long> id;
    //引起原因
    private String measures;
    //解决方式
    private  String solve;
    //级别
    private String level;
}
