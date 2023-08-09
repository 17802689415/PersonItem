package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.CleanroomTestInfoMapper;
import com.it.mapper.WaterTestInfoMapper;

import com.it.pojo.CleanroomTestInfo;
import com.it.pojo.WaterTestInfo;
import com.it.service.CleanroomTestInfoService;
import com.it.service.WaterTestInfoService;
import org.springframework.stereotype.Service;

@Service
public class CleanroomTestInfoServiceImpl extends ServiceImpl<CleanroomTestInfoMapper, CleanroomTestInfo> implements CleanroomTestInfoService {
}
