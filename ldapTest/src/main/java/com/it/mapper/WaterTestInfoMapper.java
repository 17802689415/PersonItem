package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.UserInfo;
import com.it.pojo.WaterTestInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WaterTestInfoMapper extends BaseMapper<WaterTestInfo> {
}
