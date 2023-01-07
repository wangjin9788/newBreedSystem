package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.common.utils.MailUtils;
import com.breed.govern.dto.param.SendFormulaMallParam;
import com.breed.govern.dto.vo.BreedFormulaListVo;
import com.breed.govern.dto.vo.UpdateFeedFormulaInfo;
import com.breed.govern.entity.BBreedFormula;
import com.breed.govern.entity.BBreedFormulaLabel;
import com.breed.govern.entity.BFeedFerment;
import com.breed.govern.service.IBFeedFermentService;
import com.breed.govern.service.IBBreedFormulaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 饲料配置表
 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-22
 */
@RestController
@RequestMapping("/feed-formula")
public class BBreedFormulaController {

    final static String title = "饲料计算结果";

    final static String ADDRESSEE = "980642298@qq.com";

    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private IBBreedFormulaService formulaService;

    @Autowired
    private IBFeedFermentService fermentService;

    @ApiOperation("获取饲料配方列表")
    @GetMapping(value = "/list")
    public CommonResult<List<BreedFormulaListVo>> getFormulaList(@RequestParam(value = "type")Integer type) {
        return CommonResult.success(formulaService.getFormulaList(type));
    }
    @ApiOperation("获取饲料配方列表")
    @GetMapping(value = "/select/type")
    public CommonResult<List<BBreedFormulaLabel>> selectFormulaType() {
        return CommonResult.success(formulaService.selectFormulaType());
    }



    @ApiOperation("根据id获取配方信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<UpdateFeedFormulaInfo> getFormulaInfoById(@PathVariable Integer id) {
        return CommonResult.success(formulaService.getFormulaInfoById(id));
    }

    @ApiOperation("邮件发送")
    @PostMapping(value = "/send/mail")
    @ResponseBody
    public CommonResult sendFormulaMail(@RequestBody SendFormulaMallParam data) {

        if(data!=null&&data.getWeight()>0) {
            StringBuffer str = new StringBuffer();
            StringBuffer buff = new StringBuffer();
            buff.append("<html><body><table  width=\"120%\" ><tr><td  width=\"5%\">总重量</td><td width=\"15%\">配方</td><td width=\"5%\">结果</td><td width=\"10%\">制作方法</td></tr>");
            str.append("<ol><li><strong>重量</strong></li><li class=\"ql-indent-1\"><strong>"+data.getWeight() +  "/"+data.getWeightUnit()+"</strong></li><li><strong>配方结果:</strong>");
            for (int i = 0; i < data.getResults().size(); i++) {
                str.append("</li><li class=\"ql-indent-1\"><strong>"+data.getFormulaStr().get(i)+"     原料重量:"+data.getResults().get(i) +"/"+data.getWeightUnit()+""+"</strong></li>");
                buff.append("<tr>");
                if(i==0){
                    buff.append("<td width=\"5%\" rowspan="+data.getResults().size()+">");
                    buff.append(data.getWeight() +  "/"+data.getWeightUnit()+""+"</td>");
                }
                buff.append("<td width=\"15%\">" + data.getFormulaStr().get(i) + "</td><td width=\"5%\">" + data.getResults().get(i) +"/"+data.getUnit()+"</td>");
                if(i==0){
                    buff.append("<td width=\"10%\" rowspan="+data.getResults().size()+">");
                    buff.append(data.getMarkMethod()+"</td>");
                }

                buff.append("</tr>");
            }
            buff.append("</table></body></html>");
            str.append("</ol>");
            mailUtils.sendHtmlMail(ADDRESSEE, title, buff.toString());
            if(data.getRadio()==2){
                BFeedFerment ferment =new BFeedFerment();
                ferment.setStatus(0);
                ferment.setFermentInfo(str.toString());
                ferment.setFermentTime(LocalDateTime.now());
                fermentService.createFeedFerment(ferment);
            }
            return CommonResult.success("发送成功");
        }
        return CommonResult.failed("发送失败");


    }

}
