package com.yizu.house.entity;

import lombok.Data;

/**
 * @Package: com.yizu.house.entity
 * @ClassName: PicUploadResult
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/16 15:27
 */
@Data
public class PicUploadResult {

    // 文件唯一标识
    private String uid;
    // 文件名
    private String name;
    // 状态有：uploading done error removed
    private String status;
    // 服务端响应内容，如：'{"status": "success"}'
    private String response;
}
