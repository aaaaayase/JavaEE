package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;


public class UdpDictServer extends UdpEchoServer {

    private HashMap<String, String> dict = null;

    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict = new HashMap<>();
        dict.put("hello", "你好");
        dict.put("pig", "小猪");
        dict.put("dog", "小狗");
        dict.put("cat", "小猫");
    }

    @Override
    public String process(String request) {
        return (String) dict.getOrDefault(request, "未搜索到单词");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer dictServer = new UdpDictServer(4090);
        dictServer.start();

    }
}
