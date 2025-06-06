package org.example.socket;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TcpServerStarter {
    private final TcpServer tcpServer;

    public TcpServerStarter(TcpServer tcpServer) {
        this.tcpServer = tcpServer;
    }

    // 应用启动后启动 TCP 服务
    @EventListener(ApplicationReadyEvent.class)
    public void startTcpServer() {
        new Thread(tcpServer).start(); // 避免阻塞主线程
    }
}