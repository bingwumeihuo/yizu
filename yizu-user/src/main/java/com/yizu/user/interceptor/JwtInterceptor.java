package com.yizu.user.interceptor;

import com.yizu.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Package: com.yixin.user.interceptor
 * @ClassName: JwtInterceptor
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/5/26 23:16
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //无论如何都放行，具体能不能操作还得去具体操作中判断
        //拦截器的作用是负责抽取请求头中的token进行验证
        String header =request.getHeader("Authorization");
		if (header!=null&&!"".equals(header)){
            //如果头信息包含Authorization就对其进行解析
            if (header.startsWith("Bearer ")){
            }
		}
		//得到token
		String token =header.substring(7);
		//对令牌进行验证
			Claims claims=jwtUtil.parseJWT(token);
			String roles= (String) claims.get("roles");
			//如果是管理员
			if (roles!=null&&roles.equals("admin")){
			    request.setAttribute("claims-admin",token);
			}
            if (roles!=null&&roles.equals("user")){
                request.setAttribute("claims-user",token);

		}
        return true;



    }
}
