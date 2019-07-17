package com.yizu.house.controller;

import com.yizu.house.entity.PicUploadResult;
import com.yizu.house.service.PicUploadFileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Package: com.yizu.house.controller
 * @ClassName: PicUploadController
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/16 15:26
 */
@RequestMapping("/pic/upload")
@Controller
public class PicUploadController {
    @Autowired
    private PicUploadFileSystemService picUploadService;
    @PostMapping
    @ResponseBody
    public PicUploadResult upload(@RequestParam("file") MultipartFile multipartFile) {
        return this.picUploadService.upload(multipartFile);
    }
}

