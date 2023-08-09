package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.SampleInfoMapper;
import com.it.mapper.WaterTestInfoMapper;
import com.it.pojo.SampleInfo;
import com.it.pojo.WaterTestInfo;
import com.it.service.SampleInfoService;
import com.it.service.WaterTestInfoService;
import org.springframework.stereotype.Service;

@Service
public class WaterTestInfoServiceImpl extends ServiceImpl<WaterTestInfoMapper, WaterTestInfo> implements WaterTestInfoService {
}
