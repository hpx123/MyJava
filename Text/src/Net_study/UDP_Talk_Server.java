package Net_study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP_Talk_Server implements Runnable{

    private DatagramSocket server;
    private String from;

    public UDP_Talk_Server(int port,String from) {
        this.from = from;
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            byte[] container = new byte[1024 * 60];//最多60k
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3.阻塞式接受包裹receive
            try {
                server.receive(packet);
                //4.分析数据
                byte[] datas = packet.getData();
                int len = packet.getLength();
                System.out.println(from + "对你说：");
                String data = new String(datas, 0, len);
                System.out.println(data);
                if(data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        server.close();
    }
}
