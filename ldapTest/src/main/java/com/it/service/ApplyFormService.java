package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pojo.ApplyForm;
import org.apache.ibatis.annotations.Param;

public interface ApplyFormService extends IService<ApplyForm> {

    boolean updateStepByCaseNum(String step,String caseNum);
}
