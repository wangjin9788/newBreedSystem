package com.breed.govern.component;

import com.alibaba.excel.EasyExcel;
import com.breed.govern.dto.data.ExcelData;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * ***********************************************************
 *
 * @类名 : ExcelTest
 * @DESCRIPTION :
 * @AUTHOR :  wj
 * @DATE :  2022/12/9
 * ***********************************************************
 */
public class ExcelTest {
    @Value("${excel.fileName}")
    String filename;
    public void test(){
        List<ExcelData> list = EasyExcel.read(filename).head(ExcelData.class).sheet().doReadSync();
        for (ExcelData data :list){
            System.out.println(data);
        }

    }


}


