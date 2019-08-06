package Net_study;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import static java.lang.System.in;

/**
 * 发送端
 * 1.使用DatagramSocket 指定端口，创建发送端
 * 2.准备数据，一定转成字节数组
 * 3.封装成DatagramPacket 包裹 需要指定目的地
 * 4.发送包裹send
 * 5.释放资源
 */
public class UDP_Client {

    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中...");
        //1.使用DatagramSocket 指定端口，创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //2.准备数据，一定转成字节数组
        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            // 3.封装成DatagramPacket 包裹 需要指定目的地
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                    new InetSocketAddress("localhost", 9999));
            //4.发送包裹send
            client.send(packet);
            if(data.equals("bye")){
                break;
            }
        }
        //5.释放资源
        client.close();
    }
}
