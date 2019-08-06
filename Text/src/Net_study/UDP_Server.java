package Net_study;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接受端
 * 1.使用DatagramSocket 指定端口，创建接收端
 * 2.准备容器，封装成DatagramPacket 包裹
 * 3.阻塞式接受包裹receive
 * 4.分析数据
 * byte[]   getData()
 *          getLength()
 * 5.释放资源
 */

public class UDP_Server {

    public static void main(String[] args) throws Exception {
        System.out.println("接受中...");
        //1.使用DatagramSocket 指定端口，创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        //2.准备容器，封装成DatagramPacket 包裹
        while(true) {
            byte[] container = new byte[1024 * 60];//最多60k
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3.阻塞式接受包裹receive
            server.receive(packet);
            //4.分析数据
            byte[] datas = packet.getData();
            int len = packet.getLength();
            String data = new String(datas, 0, len);
            System.out.println(data);
            if(data.equals("bye")){
                break;
            }
        }
        //5.释放资源
        server.close();
    }
}
