package com.it.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.pojo.*;
import com.it.service.*;
import com.it.pojo.PageCommon;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/lab")
public class UserController {


    @Autowired
    private UserInfoService loginService;


    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    @PostMapping("/login")
    @ResponseBody
//    @CachePut(value = "userCache",key = "#log.username")
//    @Cacheable(value = "userCache",key = "#log.username")
    public R<UserDetails> userManager(UserInfo log){

        return loginService.login(log);
    }



    @PostMapping("/selectCase")
    @ResponseBody
    public R<Page> selectCase(PageCommon pageCommon){
//        //分页构造器
//        Page pageInfo = new Page(pageCommon.getPage(),pageCommon.getPageSize());
//
//        LambdaQueryWrapper<ApplyForm> queryWrapper =new LambdaQueryWrapper<>();
//        queryWrapper.orderByAsc(ApplyForm::getUpdateTime);
//        applyFormService.page(pageInfo,queryWrapper);
        return null;
    }


}
