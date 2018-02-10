package com.xin.lemontree.controller.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author creator mafh 2018/2/10 17:02
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@ServerEndpoint(value = "/mywebsocket")
@Component
public class MyWebsocket {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebsocket> websockets = new CopyOnWriteArraySet<MyWebsocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 日志记录
     */
    private static Logger logger = LoggerFactory.getLogger(MyWebsocket.class);

    /**
     * 连接建立成功调用的方法
     *
     * @param session 会话
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        // 加入set中
        websockets.add(this);
        // 在线数 + 1
        addOnlineCount();
        logger.debug("有新连接加入！当前websocket在线人数为" + onlineCount);
        try {
            sendMessage("连接建立成功！");
        } catch (IOException e) {
            logger.error("IO异常", e);
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        // 从set中删除
        websockets.remove(this);
        // 在线数 - 1
        reduceOnlineCount();
        logger.debug("有一连接关闭！当前websockt在线人数为" + onlineCount);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.debug("客户端发送来的消息：" + message);
        // 群发消息
        for (MyWebsocket websocket : websockets) {
            try {
                websocket.sendMessage(message);
            } catch (IOException e) {
                logger.error("群发消息异常", e);
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session 会话
     * @param error   错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.debug("发生错误");
        error.printStackTrace();
    }


    /**
     * 发送消息
     *
     * @param message 消息内容
     * @throws IOException io异常
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 自增（线程安全）
     */
    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    /**
     * 自减（线程安全）
     */
    public static synchronized void reduceOnlineCount() {
        onlineCount--;
    }
}
