package com.it.controller;

import com.it.pojo.Login;
import com.it.pojo.UserInfo;
import com.it.service.UserInfoService;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserInfoService loginService;
    @GetMapping("/info")
    @ResponseBody
    public String info(){

        return "success";
    }
    @PostMapping("/login")
    @ResponseBody
    public R<UserDetails> userManager(Login log){

        return loginService.login(log);
    }
}
