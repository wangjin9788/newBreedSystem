package com.breed.govern.controller;

import com.breed.govern.common.api.CommonResult;
import com.breed.govern.common.utils.MailUtils;
import com.breed.govern.dto.data.OperationBatchData;
import com.breed.govern.dto.param.NutritionClaParam;
import com.breed.govern.service.IBExcOperationService;
import com.breed.govern.service.IBOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Api(tags = "MinioController", description = "MinIO对象存储管理")
@Controller
@RequestMapping("/nutritionCla")

public class NutritionClaController {

    @Autowired
    private IBExcOperationService excOperationService;
    @Autowired
    private IBOperationService operationService;

    @Autowired
    private MailUtils mailUtils;


    final static String ADDRESSEE = "980642298@qq.com";
    final static String title = "计算结果";

    @ApiOperation("添加养殖结束信息")
    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult createBreedBreedOut(@RequestBody NutritionClaParam data) {
        if (data != null) {
            StringBuffer buff = new StringBuffer();
            StringBuffer operationBuff = new StringBuffer();
            buff.append("<html><body><table cellpadding=10><tr><td  width=300px>介质</td><td width=300px>比例</td><td width=300px>结果</td></tr>");
            operationBuff.append("<ol>");
            for (int i = 0; i < data.getDomains().size(); i++) {
                String domain = data.getMediums().get(i).getValue() + ":" + data.getDomains().get(i).getValue();
                String rate = data.getRates().get(i).getValue().get(0) + ":" + data.getRates().get(i).getValue().get(1) + "%";
                String result = data.getResults().get(i).getValue();
                buff.append("<tr><td width=300px>" + domain + "</td><td width=300px>" + rate + "</td><td width=300px>" + result + "</td></tr>");
                operationBuff.append("<li>" + domain + "--" + rate + "--" + result + "</li>");
            }
            buff.append("</table></body></html>");
            operationBuff.append("</ol>");
            mailUtils.sendHtmlMail(ADDRESSEE, title, buff.toString());
        }
        return CommonResult.success("");
    }

}

