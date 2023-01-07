package com.breed.govern.dto.data;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

/**
 * ***********************************************************
 *
 * @类名 : ExcelData
 * @DESCRIPTION :
 * @AUTHOR :  wj
 * @DATE :  2022/12/9
 * ***********************************************************
 */
@HeadRowHeight(20)
@ColumnWidth(20)
public class ExcelData {
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("年龄")
    private int  age;
    @ExcelProperty("性别")
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ExcelData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
