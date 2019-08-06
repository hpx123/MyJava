package Net_study;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.指定端口，创建ServerSocket
 * 2.阻塞，等待连接accept
 * 3.操作：输入输出流操作
 * 4.关闭
 */
public class Server {

    public static void main(String[] args) throws Exception {
        System.out.println("---Server---");
        //1.指定端口，创建ServerSocket
        ServerSocket server = new ServerSocket(9999);
        //2.阻塞，等待连接accept
        Socket client = server.accept();//建立了一个客户端
        System.out.println("建立了一个客户端");
        //3.操作：输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        //4.关闭
        dis.close();
        client.close();
    }
}
