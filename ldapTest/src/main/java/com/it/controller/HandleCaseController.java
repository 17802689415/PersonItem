package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.ApplyForm;
import com.it.pojo.BatchCommon;
import com.it.pojo.InspectorTaskInfo;
import com.it.service.ApplyFormService;
import com.it.service.InspectorTaskInfoService;
import com.it.utils.MailUtil;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lab")
public class HandleCaseController {

    @Autowired
    private ApplyFormService applyFormService;

    @Autowired
    private InspectorTaskInfoService inspectorTaskInfoService;

    @PostMapping("/batchAllocation")
    @PreAuthorize("hasAuthority('ROLE_operator')")
    @ResponseBody
    public R batchAllocation(BatchCommon batchCommon){

        for (String caseNum:batchCommon.getCaseList()) {
            InspectorTaskInfo inspectorTaskInfo =new InspectorTaskInfo();
            inspectorTaskInfo.setCaseNum(caseNum);
            inspectorTaskInfo.setJobId(batchCommon.getTestUserValue());
            LambdaQueryWrapper<ApplyForm> queryWrapper =new LambdaQueryWrapper();
            queryWrapper.eq(ApplyForm::getCaseNum,caseNum);
            ApplyForm one = applyFormService.getOne(queryWrapper);
            inspectorTaskInfo.setTestType(one.getTestType());
            inspectorTaskInfo.setStatus("待检测");
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            inspectorTaskInfo.setBeginDate(dateFormat.format(date));
            boolean save = inspectorTaskInfoService.save(inspectorTaskInfo);
            if (!save){
                return R.error("error",0);
            }
            boolean b = applyFormService.updateStepByCaseNum(inspectorTaskInfo.getStatus(), inspectorTaskInfo.getCaseNum());
            if (!b){
                return R.error("error",0);
            }
        }
        boolean labTask = MailUtil.sendMail("2080244933@qq.com", "Lab Task", "你有新的任务，请前往系统查看");
        if (!labTask){
            return R.error("邮件发送错误",0);
        }
        return R.success("success",1);

    }


    @PostMapping("/batchReception")
    @PreAuthorize("hasAuthority('ROLE_operator')")
    @ResponseBody
    public R batchReception(BatchCommon batchCommon) {

        for (String caseNum:batchCommon.getCaseList()) {
            InspectorTaskInfo inspectorTaskInfo =new InspectorTaskInfo();

            inspectorTaskInfo.setCaseNum(caseNum);
            inspectorTaskInfo.setJobId(batchCommon.getTestUserValue());

            LambdaQueryWrapper<ApplyForm> queryWrapper =new LambdaQueryWrapper();
            queryWrapper.eq(ApplyForm::getCaseNum,caseNum);
            ApplyForm one = applyFormService.getOne(queryWrapper);

            inspectorTaskInfo.setTestType(one.getTestType());
            inspectorTaskInfo.setStatus("检测中");

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            inspectorTaskInfo.setBeginDate(dateFormat.format(date));

            boolean save = inspectorTaskInfoService.save(inspectorTaskInfo);
            if (!save){
                return R.error("error",0);
            }
            boolean b = applyFormService.updateStepByCaseNum(inspectorTaskInfo.getStatus(), inspectorTaskInfo.getCaseNum());
            if (!b){
                return R.error("error",0);
            }
        }
        boolean labTask = MailUtil.sendMail("2080244933@qq.com", "Lab Task", batchCommon.getTestUserValue()+"已领取任务，请前往系统查看");
        if (!labTask){
            return R.error("邮件发送错误",0);
        }
        return R.success("success",1);
    }
}
