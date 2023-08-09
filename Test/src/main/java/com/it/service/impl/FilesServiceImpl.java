package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.FilesMapper;
import com.it.service.FilesService;
import org.springframework.stereotype.Service;
import com.it.pojo.FilesData;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper, FilesData> implements FilesService{



    public String upload(MultipartFile file,String caseNum) throws IOException {

        if (file.isEmpty()) {
            log.error("the file to be uploaded is empty");
            return null;
        }

            //首次需生成目录
            File folder = new File(filePath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String fileName =  file.getOriginalFilename();
            String absolutePath = filePath + fileName;

            file.transferTo(new File(absolutePath));

            String separator = "/";
            String path = separator + pathPattern + separator + fileName;
            String type = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            double size = file.getSize();
//            String md5 = DigestUtils.md5DigestAsHex(file.getInputStream());
            FilesData filesData = new FilesData();
            filesData.setCaseNum(caseNum);
            filesData.setFilesName(fileName);
            filesData.setType(type);
            filesData.setSize(size);
            filesData.setUrl(path);
//            filesData.setMd5(md5);
            save(filesData);


        return path;
    }

    public static String timeFormat(Long time) {
        if (Objects.isNull(time)) {
            return null;
        }
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(time);
    }

    //将文件以流的形式一次性读取到内存，通过响应输出流输出到前端
    @Override
    public void download(String caseNum) {

    }

    //通过文件MD5查询文件
    private FilesData getFileByMD5(String md5) {
        //查找数据库是否已经存在一样的图片
        QueryWrapper<FilesData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5", md5);
        List<FilesData> filesList = list(queryWrapper);
        return filesList.size() == 0 ? null : filesList.get(0);
    }
}

