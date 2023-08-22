package com.hqu.controller;
import com.hqu.pojo.Result;
import com.hqu.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        log.info("文件上传，文件:{}",file.getOriginalFilename());
        String url = aliOSSUtils.upload(file);
        log.info("文件上传完成，文件访问在url:{}",url);
        return Result.success(url);
    }
}
