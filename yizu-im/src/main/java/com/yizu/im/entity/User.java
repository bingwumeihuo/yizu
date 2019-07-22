package com.yizu.im.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: com.yizu.im.entity
 * @ClassName: User
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/23 1:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String username;
}
