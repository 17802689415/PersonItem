package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.CleanroomTestInfoMapper;
import com.it.mapper.InspectorTaskInfoMapper;
import com.it.pojo.CleanroomTestInfo;
import com.it.pojo.InspectorTaskInfo;
import com.it.service.CleanroomTestInfoService;
import com.it.service.InspectorTaskInfoService;
import org.springframework.stereotype.Service;

@Service
public class InspectorTaskInfoServiceImpl extends ServiceImpl<InspectorTaskInfoMapper, InspectorTaskInfo> implements InspectorTaskInfoService {
}
