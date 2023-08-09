package com.it.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.pojo.*;
import com.it.service.*;
import com.it.pojo.PageCommon;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/lab")
public class SelectCaseController {

    @Autowired
    private ApplyFormService applyFormService;

    @Autowired
    private InspectorTaskInfoService inspectorTaskInfoService;

    @Autowired
    private SampleTestInfoService sampleTestInfoService;

    @Autowired
    private ConsignorInfoService consignorInfoService;

    @Autowired
    private UserInfoService userInfoService;



    @PostMapping("/selectUrgentCase")
    @ResponseBody
    public R<List<ApplyForm>> selectUrgentCase(){

        LambdaQueryWrapper<ApplyForm> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.and(i -> i.eq(ApplyForm::isUrgent,true).eq(ApplyForm::getStatus,"unfinished"));
        List<ApplyForm> list = applyFormService.list(queryWrapper);
        return R.success(list,1);

    }

    @PostMapping("/selectWaitCase")
    @ResponseBody
    public R<List<InspectorTaskInfo>> selectWaitCase(){

        LambdaQueryWrapper<InspectorTaskInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(InspectorTaskInfo::getStatus,"待检测").or().eq(InspectorTaskInfo::getStatus,"检测中").orderByAsc(InspectorTaskInfo::getBeginDate);

        List<InspectorTaskInfo> list = inspectorTaskInfoService.list(queryWrapper);
        return R.success(list,1);
    }

    @PostMapping("/selectSampleTestInfo")
    @ResponseBody
    public R<List<SampleTestInfo>> selectSampleTestInfo(String caseNum){

        LambdaQueryWrapper<SampleTestInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SampleTestInfo::getCaseNum,caseNum);
        List<SampleTestInfo> list = sampleTestInfoService.list(queryWrapper);
        return R.success(list,1);
    }


    @PostMapping("/selectMyCase")
    @ResponseBody
    public R<Page> selectMyCaseBy(PageCommon pageCommon){
        Page pageInfo = new Page(pageCommon.getPage(),pageCommon.getPageSize());
        List list = new ArrayList();

        LambdaQueryWrapper<UserInfo> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername,pageCommon.getUsername());
        UserInfo one = userInfoService.getOne(queryWrapper);

        LambdaQueryWrapper<ApplyForm> queryWrapper1 =new LambdaQueryWrapper<>();
        queryWrapper1.and(i -> i.like(ApplyForm::getTestType,pageCommon.getTypeValue()).like(ApplyForm::getStatus,pageCommon.getStatusValue()).eq(ApplyForm::getConsignorId,one.getJobId()));
        

        Page page = applyFormService.page(pageInfo, queryWrapper1);

        return R.success(page,1);
    }




    @PostMapping("/selectConsignor")
    @ResponseBody
    public R<List<ConsignorInfo>> selectConsignor(String caseNum){

        LambdaQueryWrapper<ConsignorInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ConsignorInfo::getCaseNum,caseNum);
        List<ConsignorInfo> list = consignorInfoService.list(queryWrapper);
        return R.success(list,1);
    }


    @PostMapping("/selectHandleCase")
    @ResponseBody
    public R<Page> selectHandleCase(PageCommon pageCommon){
        Page pageInfo = new Page(pageCommon.getPage(),pageCommon.getPageSize());


        LambdaQueryWrapper<ApplyForm> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.and(i -> i.like(ApplyForm::getTestType,pageCommon.getTypeValue()).likeRight(ApplyForm::getStatus,pageCommon.getStatusValue()).eq(ApplyForm::getStep,"submitted"));
        Page page = applyFormService.page(pageInfo, queryWrapper);


        return R.success(page,1);
    }




    @PostMapping("/selectAllCase")
    @ResponseBody
    public R<Page> selectAllCase(PageCommon pageCommon){
        Page pageInfo = new Page(pageCommon.getPage(),pageCommon.getPageSize());


        LambdaQueryWrapper<ApplyForm> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.and(i -> i.like(ApplyForm::getTestType,pageCommon.getTypeValue()).likeRight(ApplyForm::getStatus,pageCommon.getStatusValue()));
        Page page = applyFormService.page(pageInfo, queryWrapper);

        return R.success(page,1);
    }


}
