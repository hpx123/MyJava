package Net_study;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        System.out.println("请输入用户名：");
        BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
        //1.建立连接：使用Socket创建客户端+服务的地址和端口
        Socket client = new Socket("192.168.1.90",8888);
        //发送端
        new Thread(new ChatClient_Send(client, name.readLine())).start();
        new Thread(new ChatClient_Receive(client)).start();

    }
}
