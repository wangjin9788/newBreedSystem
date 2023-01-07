package com.breed.govern.timeSendMail;

import com.breed.govern.common.utils.MailUtils;
import com.breed.govern.dto.data.ExcInfoTipsSendMailData;
import com.breed.govern.entity.AdAnimalDisease;
import com.breed.govern.entity.BExcInfo;
import com.breed.govern.entity.BTesting;
import com.breed.govern.entity.BTipsInfo;
import com.breed.govern.service.IAdAnimalDiseaseService;
import com.breed.govern.service.IBExcInfoService;
import com.breed.govern.service.IBTestingService;
import com.breed.govern.service.IBTipsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api("定时发送异常信息或邮件信息")
@Component
public class ExcInfoTipsSendMail {
    final static String ADDRESSEE = "980642298@qq.com";
    final static String excInfoTitle = "异常提醒";
    final static String tipsTitle = "提示信息";
    @Autowired
    private MailUtils mailUtils;


    @Autowired
    private IBTestingService testingService;
    @Autowired
    private IBExcInfoService excInfoService;
    @Autowired
    private IBTipsInfoService tipsInfoService;
    @Autowired
    private IAdAnimalDiseaseService adService;

    @ApiOperation("每天13点定时发送")
    @Scheduled(cron = "0 0 13 * * ?")
    public void sendMail() {
        List<ExcInfoTipsSendMailData> sendData = new ArrayList<>();
        //获取当天的检测信息
        List<BTesting> testingList = testingService.getDayTestingList();
        //获取今天异常信息
        List<BExcInfo> dayExcInfo = excInfoService.getDayExcInfo();
        //获取提示信息
        List<BTipsInfo> tipsInfo = tipsInfoService.getTipsInfo();

        List<Long> adList = new ArrayList<>();
        for (BExcInfo excInfo : dayExcInfo) {
            AdAnimalDisease animal = adService.getAllAnimalDisease(excInfo.getAdId());
            //校验病情不同新增
            if (!adList.contains(excInfo.getAdId())) {
                List<Long> ids = new ArrayList<>();
                ids.add(excInfo.getBId());
                adList.add(excInfo.getBId());
                ExcInfoTipsSendMailData data = new ExcInfoTipsSendMailData();
                data.setId(ids);
                data.setMeasures(animal.getPathogeny());
                data.setSolve(animal.getTreatment());
                data.setLevel("待操作");
                sendData.add(data);
            } else if (adList.contains(excInfo.getAdId())) {
                //循环已经存在的病情
                for (ExcInfoTipsSendMailData info : sendData) {
                    if (info.getMeasures().contains(animal.getPathogeny())) {
                        info.getId().add(excInfo.getBId());
                    }
                }
            }
        }
        //邮件发送
        if (sendData != null && sendData.size() > 0) {
            senMail(sendData, excInfoTitle);
            sendData = new ArrayList<>();
        }
        //获取已经存在的id
        //List<List<Long>> idList = sendData.stream().map(ExcInfoTipsSendMailData::getId).collect(Collectors.toList());
        //校验重复性
        List<String> list = new ArrayList<>();
        //处理提醒级别
        for (BTesting testing : testingList) {
            //校验养殖编号id是否已经存在发送数据中，存在不在操作
            StringBuffer buffer = new StringBuffer();
            //不存在
            for (BTipsInfo tips : tipsInfo) {
                switch (tips.getMark()) {
                    case 0:
                        checkTips(testing.getTemperature(), tips, buffer);
                        break;
                    case 1:
                        checkTips(testing.getBreedTemperature(), tips, buffer);
                        break;
                    case 2:
                        checkTips(testing.getBreedHumidity(), tips, buffer);
                        break;
                    case 3:
                        checkTips(testing.getPh(), tips, buffer);
                        break;
                }

            }
            if (!list.contains(buffer)) {
                list.add(buffer.toString());

                if (buffer != null && buffer.length() > 0) {
                    List<Long> ids = new ArrayList<>();
                    ids.add(testing.getBId());
                    ExcInfoTipsSendMailData tipsData = new ExcInfoTipsSendMailData();
                    tipsData.setId(ids);
                    tipsData.setMeasures(buffer.toString());
                    tipsData.setSolve(buffer.toString());
                    tipsData.setLevel("提醒");
                    sendData.add(tipsData);
                }
            } else {
                //循环已经存在的病情
                for (ExcInfoTipsSendMailData info : sendData) {
                    //判断病害是否相同相同累加id
                    if (info.getMeasures().contains(buffer.toString())) {
                        info.getId().add(testing.getBId());
                    }
                }
            }


        }
        //邮件发送
        if (sendData != null && sendData.size() > 0) {
            senMail(sendData, tipsTitle);
        }

    }

    private void senMail(List<ExcInfoTipsSendMailData> sendData, String title) {
        StringBuffer buff = new StringBuffer();
        buff.append("<html><body><table cellpadding=10><tr><td  width=300px>养殖编号</td><td width=300px>引起原因</td><td width=300px>解决方法</td><td width=300px>提醒级别</td></tr>");
        for (ExcInfoTipsSendMailData info : sendData) {
            buff.append("<tr><td width=300px>" + info.getId() + "</td><td width=300px>" + info.getMeasures() + "</td><td width=300px>" + info.getSolve() + "</td><td width=300px>" + info.getLevel() + "</td></tr>");
        }
        buff.append("</table></body></html>");
        mailUtils.sendHtmlMail(ADDRESSEE, title, buff.toString());
    }

    private void checkTips(Double value, BTipsInfo tips, StringBuffer buffer) {
        if (value <= tips.getCondition()[0]) {
            buffer.append(tips.getMinMeasures() + "--");
        } else if (value >= tips.getCondition()[1]) {
            buffer.append(tips.getMaxMeasures() + "--");
        }
    }
}
