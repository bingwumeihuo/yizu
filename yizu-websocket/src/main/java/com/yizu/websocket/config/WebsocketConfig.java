package com.yizu.websocket.config;

import com.yizu.websocket.service.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Package: com.yizu.websocket.config
 * @ClassName: WebsocketConfig
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/22 23:08
 */
@EnableWebSocket
@Configuration
public class WebsocketConfig implements WebSocketConfigurer {
    @Autowired
    private MyHandshakeInterceptor myHandshakeInterceptor;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/ws").setAllowedOrigins("*")
        .setAllowedOrigins("*")
        .addInterceptors(this.myHandshakeInterceptor);
    }
    @Bean
    public WebSocketHandler myHandler(){
        return new MyHandler();
    }
}
