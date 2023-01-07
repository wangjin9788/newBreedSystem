package com.breed.govern.component;

import com.alibaba.excel.EasyExcel;
import com.breed.govern.dto.data.ExcelData;

import java.util.List;

public class ExcelUtil {
    String filename = "D:\\excel\\ExcelData.xlsx";
    public  List<ExcelData> readExcel(){
    return EasyExcel.read(filename).head(ExcelData.class).sheet().doReadSync();
    }
}
