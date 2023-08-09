package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.ApplyFormMapper;
import com.it.mapper.UserInfoMapper;
import com.it.pojo.ApplyForm;
import com.it.pojo.UserInfo;
import com.it.service.ApplyFormService;
import com.it.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyFormServiceImpl extends ServiceImpl<ApplyFormMapper, ApplyForm> implements ApplyFormService {

    @Autowired
    private ApplyFormMapper applyFormMapper;
    @Override
    public boolean updateStepByCaseNum(String step,String caseNum) {
        try {
            applyFormMapper.updateStepByCaseNum(step, caseNum);
        }catch (Exception e){
            return false;
        }

        return true;
    }
}
