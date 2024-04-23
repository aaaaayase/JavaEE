package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoClient {

    private DatagramSocket datagramSocket = null;

    public UdpEchoClient(int port) throws SocketException {
        datagramSocket = new DatagramSocket(port);

    }

    public void start() throws IOException {
        System.out.println("服务器启动！！！");
        while (true) {
            // 1.读取请求并且解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            datagramSocket.receive(requestPacket);
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());

            // 2.处理计算请求信息
            String response = process(request);

            // 3.把响应返回客户端 客户端的ip以及端口号可以通过请求的数据包中获取
            DatagramPacket responsePacket = new DatagramPacket(request.getBytes(), 0, request.getBytes().length,
                    requestPacket.getSocketAddress());
            datagramSocket.send(responsePacket);

            // 打印日志 ip port 请求以及返回内容
            System.out.println("request=" + request);
            System.out.println("response=" + response);
            System.out.println("ip="+requestPacket.getAddress());
            System.out.println("port="+requestPacket.getPort());

        }
    }

    private String process(String request) {

        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient(4090);
        udpEchoClient.start();
    }

}
