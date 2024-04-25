package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {

    private DatagramSocket datagramSocket = null;
    private String serverIp;
    private int port;

    public UdpEchoClient(String ip, int port) throws SocketException {
        datagramSocket = new DatagramSocket();
        this.serverIp = ip;
        this.port = port;
    }

    public void start() throws IOException {
        System.out.println("客户端启动！！！");
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 输入请求
            System.out.println("请输入请求：");
            String request = sc.nextLine();
            // 打包请求并且发送请求
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), 0, request.getBytes().length, InetAddress.getByName(serverIp), port);
            datagramSocket.send(requestPacket);

            // 接收响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            datagramSocket.receive(responsePacket);

            // 打印响应的内容
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("响应：" + response);

        }

    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("localhost", 4090);
        client.start();

    }

}
