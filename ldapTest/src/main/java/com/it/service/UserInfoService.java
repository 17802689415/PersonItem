package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pojo.UserInfo;
import com.it.utils.R;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserInfoService extends IService<UserInfo> {
    R<UserDetails> login(UserInfo log);
}
