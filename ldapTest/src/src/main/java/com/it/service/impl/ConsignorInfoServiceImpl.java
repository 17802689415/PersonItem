package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.ConsignorInfoMapper;
import com.it.pojo.ConsignorInfo;
import com.it.service.ConsignorInfoService;
import org.springframework.stereotype.Service;

@Service
public class ConsignorInfoServiceImpl extends ServiceImpl<ConsignorInfoMapper, ConsignorInfo> implements ConsignorInfoService {
}
