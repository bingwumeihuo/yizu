package com.yizu.user.service;

import com.yizu.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package: com.yizu.user.service
 * @ClassName: UserService
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/12 0:32
 */
public class UserService {
    @Autowired
    private UserMapper userMapper;
}
