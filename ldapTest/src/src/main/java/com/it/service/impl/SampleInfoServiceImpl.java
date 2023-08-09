package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.SampleInfoMapper;
import com.it.pojo.SampleInfo;
import com.it.service.SampleInfoService;
import org.springframework.stereotype.Service;

@Service
public class SampleInfoServiceImpl extends ServiceImpl<SampleInfoMapper, SampleInfo> implements SampleInfoService {
}
