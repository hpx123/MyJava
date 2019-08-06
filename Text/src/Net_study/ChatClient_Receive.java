package Net_study;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient_Receive implements Runnable{
    private DataInputStream dis;
    private Socket client;
    private boolean isrunning;

    public ChatClient_Receive(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            isrunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取消息
    private String receive(){
        String msg = "";//避免空指针
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("你接受的时候出错了(＾Ｕ＾)ノ~ＹＯ");
            this.release();
        }
        return msg;
    }

    //释放资源
    private void release(){
        this.isrunning = false;
        CloseClass.close(dis, client);//封装
    }
    @Override
    public void run() {
        while (isrunning){
            String msg = receive();
            if(!msg.equals(null)){
                System.out.println(msg);
            }
        }

    }
}
