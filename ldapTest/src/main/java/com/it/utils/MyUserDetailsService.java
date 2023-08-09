package com.it.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.UserInfo;
import com.it.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;



@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoService loginService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername,userName);
        UserInfo one = loginService.getOne(queryWrapper);
        if (Objects.isNull(one)) {
            throw new UsernameNotFoundException("用戶不存在");
        }

//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_"+one.getRole()));
        List<String> list = new ArrayList<>();
        list.add(one.getRole());
        return new JwtUser(one,list);
    }


    public List<GrantedAuthority> getAuthority(String username){
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername,username);
        UserInfo one = loginService.getOne(queryWrapper);
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+one.getRole());
    }
}
