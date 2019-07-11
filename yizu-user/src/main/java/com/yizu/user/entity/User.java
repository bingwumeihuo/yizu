package com.yizu.user.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Package: com.yizu.user.entity
 * @ClassName: User
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/12 0:24
 */
@Data
@Table(name="user")
public class User implements Serializable {

    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
