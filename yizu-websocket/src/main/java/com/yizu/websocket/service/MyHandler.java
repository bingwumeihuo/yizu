package com.yizu.websocket.service;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.stream.IntStream;

/**
 * @Package: com.yizu.websocket.service
 * @ClassName: MyHandler
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/22 23:12
 *
 */
public class MyHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("收到消息：" + message.getPayload());
        session.sendMessage(new TextMessage("消息已收到"));
        if (message.getPayload().equals("10")) {
            IntStream.range(0,10).forEach(i->{
                try {
                    session.sendMessage(new TextMessage("消息 -> " + i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String uid= session.getAttributes().get("uid").toString();
    session.sendMessage(new TextMessage(uid+"，您好，欢迎连接到ws服务！！！"));
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)throws Exception{
        System.out.println("断开连接！！！");
    }
}

