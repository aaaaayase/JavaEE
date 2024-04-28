package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {

    ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);

    }

    public void start() throws IOException {
        System.out.println("服务器启动！！！");

        while (true) {
            // 建立连接
            Socket clientSocket = serverSocket.accept();
            // 建立线程池 这里建立的是可以自动扩容的线程池
            ExecutorService pool=Executors.newCachedThreadPool();

            // 为了方便多个客户端对服务器发起请求
            // 这里使用主线程来处理这里的循环 然后使用多线程的放式去去处理每一个客户端的请求
//            Thread t = new Thread(() -> {
//                try {
//                    processConnection(clientSocket);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//            });
//
//            t.start();

            // 使用线程池的方式
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d] 客户端上线！\n", clientSocket.getInetAddress(), clientSocket.getPort());
        // 获取字节流对象
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            Scanner sc = new Scanner(inputStream);
            while (true) {
                // 两种情况
                if (!sc.hasNext()) {
                    System.out.printf("[%s:%d] 客户端下线！\n", clientSocket.getInetAddress(), clientSocket.getPort());
                    break;
                }
                // 获取请求
                String request = sc.next();
                // 处理请求 
                String response = process(request);

                // 返回请求
                outputStream.write(response.getBytes());

                // 服务器打印日志
                System.out.printf("[%s:%d] req=%s resp=%s", clientSocket.getInetAddress(), clientSocket.getPort(), request, response);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 每次一个客户端请求的连接最后都要关闭 否则当多个客户端连接同一个服务器的时候就会出现文件描述符表爆满的问题
            // 这个问题简单想一下就会理解
            clientSocket.close();
        }

    }

    private String process(String request) {
        return request + '\n';
    }


    public static void main(String[] args) throws IOException {

        TcpEchoServer server = new TcpEchoServer(4090);
        server.start();
    }


}
