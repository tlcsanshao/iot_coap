package org.example.socket;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class TcpServerDestroyer {
    private final TcpServer tcpServer;

    public TcpServerDestroyer(TcpServer tcpServer) {
        this.tcpServer = tcpServer;
    }

    @PreDestroy
    public void onDestroy() {
        tcpServer.shutdown(); // 调用关闭逻辑
    }
}