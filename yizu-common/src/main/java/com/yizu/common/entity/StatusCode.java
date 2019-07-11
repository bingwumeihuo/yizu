package com.yizu.common.entity;

/**
 * 返回结果状态码
 * 20000 成功
 * 20001 失败
 * 20002 用户名或密码错误
 * 20003 权限不足
 * 20004 远程调用失败
 * 20005 重复操作
 * @author 式神
 * @Company
 */
public class StatusCode {

    public static final int OK=20000;
    public static final int ERROR =20001;
    public static final int LOGINERROR =20002;
    public static final int ACCESSERROR =20003;
    public static final int REMOTEERROR =20004;
    public static final int REPERROR =20005;
}
