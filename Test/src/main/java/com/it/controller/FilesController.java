package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.FilesData;
import com.it.service.FilesService;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lab")
public class FilesController {
    @Autowired
    private FilesService filesService;

    @PostMapping("/upload{caseNum}")
    @ResponseBody
    public R<String> upload(MultipartFile file,@PathVariable String caseNum){

        System.out.println(caseNum);
        String files = null;
        try {
            files = filesService.upload(file,caseNum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(files);
        return R.success(files,1);
    }

    @GetMapping("/download{caseNum}")
    public R<String> download(@PathVariable String caseNum){
        System.out.println(caseNum);
        LambdaQueryWrapper<FilesData> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(FilesData::getCaseNum,caseNum);
        FilesData one = filesService.getOne(queryWrapper);
        if (one==null){
            return R.error("error",0);
        }
        return R.success(one.getUrl(),1);
    }

    @GetMapping("/selectFiles")
    public R<List<FilesData>> selectFiles(){
        List<FilesData> list = filesService.list();
        return R.success(list,1);
    }

}
