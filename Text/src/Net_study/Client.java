package Net_study;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务的地址和端口
 * 2.操作：输入流和输出流操作
 * 3.释放
 */
public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");

         //1.建立连接：使用Socket创建客户端+服务的地址和端口
        Socket client = new Socket("localhost",9999);
         //2.操作：输入流和输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "LiXian";
        dos.writeUTF(data);
        dos.flush();
         //3.释放
        dos.close();
        client.close();
    }
}
