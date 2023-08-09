package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.it.pojo.FilesData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public interface FilesService extends IService<FilesData> {

    //拦截的url，虚拟路径
    public String pathPattern = "files";



    //自己设置的目录
    public static final String fileDir = "fileStorage";
    public String filePath = System.getProperty("user.dir") + File.separator + fileDir + File.separator;


    String upload(MultipartFile file,String caseNum) throws IOException;
    void download(String caseNum);
    
}
