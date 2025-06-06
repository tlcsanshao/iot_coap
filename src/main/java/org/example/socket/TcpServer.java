package org.example.socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author: sanshao
 * date: 2025/6/6
 * TcpServer desc:
 */

@Component
public class TcpServer implements Runnable {
    @Value("${tcp.server.port}")
    private int PORT; // 监听端口
    private ServerSocket serverSocket;
    private volatile boolean running = true; // 服务运行状态控制

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            this.serverSocket = serverSocket;
            System.out.println("✅ TCP 服务端已启动，监听端口: " + PORT);

            while (running) {
                Socket clientSocket = serverSocket.accept(); // 阻塞等待连接
                System.out.println("🔗 客户端接入: " + clientSocket.getInetAddress());
                new ClientHandler(clientSocket).start(); // 为新连接创建线程
            }
        } catch (IOException e) {
            if (running) System.err.println("❌ 服务端异常: " + e.getMessage());
        }
    }

    // 客户端连接处理器（内部类）
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) { // 持续读取数据
                    System.out.println("📥 收到消息: " + inputLine);
                    out.println("SERVER_ACK: " + inputLine); // 响应客户端
                }
            } catch (IOException e) {
                System.err.println("⚠️ 客户端通信异常: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close(); // 确保关闭连接
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 安全关闭服务
    public void shutdown() {
        running = false;
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
                System.out.println("⛔ TCP 服务已安全关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}