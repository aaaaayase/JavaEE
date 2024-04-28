package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    Socket socket = null;

    public TcpEchoClient(String ip, int port) throws IOException {
        // 这里根据ip和port号自动和服务器建立连接
        // 具体完成的操作都是系统内核完成的
        socket = new Socket(ip,port);

    }

    private void start() {
        System.out.println("客户端启动！！！");
        Scanner sc = new Scanner(System.in);
        // 获取字节流对象
        try (InputStream inputStream = socket.getInputStream(); OutputStream outputStream = socket.getOutputStream()) {
            Scanner scNetwork = new Scanner(inputStream);
            while (true) {
                System.out.println("请输入要发送的内容：");

               // 输入请求
                String request = sc.next();
                request += '\n';
                // 发送请求
                outputStream.write(request.getBytes());
                // 两中情况
                // 第一种：tcp连接断开 返回false
                // 第二种：有请求返回
                if (!scNetwork.hasNext()) {
                    break;
                }

                String response = scNetwork.next();
                System.out.println(response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("localhost", 4090);

        client.start();
    }

}
