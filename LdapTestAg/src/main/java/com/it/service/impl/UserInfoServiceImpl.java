package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.UserInfoMapper;
import com.it.pojo.UserInfo;
import com.it.service.UserInfoService;
import com.it.utils.JwtTokenUtils;
import com.it.utils.JwtUser;
import com.it.utils.R;
import com.it.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public R login(UserInfo log) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(log.getUsername(), log.getPassword(), new ArrayList<>()));
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("error");
        }
        JwtUser jwtUser=(JwtUser) authenticate.getPrincipal();
        String jwtUserName = jwtUser.getUsername();
//        Integer userId = jwtUser.getId();
        String jwt = JwtTokenUtils.createJWT(jwtUserName);
        redisCache.setCacheObject("login:"+jwtUserName,jwtUser);
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return R.success(map,200);
    }
}
