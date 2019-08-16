package NetWork;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * DatagramSocket：用于发送或接收数据包的套接字
 * DatagramPacket：数据包
 * 一切以包裹为中心
 * 模拟老师学生一对一交流
 */
public class TextUDP {
    public static void main(String[] args) throws SocketException {
        //1.开放一个端口
        DatagramSocket socket = new DatagramSocket(8050);

        //2.准备容器接受
        byte[] data = new byte[100];

        //
    }
}
