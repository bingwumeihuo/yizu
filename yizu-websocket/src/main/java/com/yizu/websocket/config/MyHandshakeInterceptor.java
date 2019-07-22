package com.yizu.websocket.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @Package: com.yizu.websocket.config
 * @ClassName: MyHandshakeInterceptor
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/23 0:13
 */
@Component
public class MyHandshakeInterceptor implements HandshakeInterceptor {


    /**
     *   * 握手之前，若返回false，则不建立链接
     *   *
     *   * @param request
     *   * @param response
     *   * @param wsHandler
     *   * @param attributes
     *   * @return
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        attributes.put("uid", 1001);
        System.out.println("开始握手。。。。。。。");
    return true;
    }


    /**
     *
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @param wsHandler
     * @param e
     */
    @Override
    public void afterHandshake(org.springframework.http.server.ServerHttpRequest serverHttpRequest, org.springframework.http.server.ServerHttpResponse serverHttpResponse, WebSocketHandler wsHandler, Exception e) {
        System.out.println("握手成功++++++++++++++");

    }
}
