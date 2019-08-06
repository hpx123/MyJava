package Net_study;

import java.io.*;
import java.net.Socket;

public class ChatClient_Send implements Runnable{
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isrunning;
    private String name;

    public ChatClient_Send(Socket client, String name) {
        this.client = client;
        this.name = name;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
            //发送名称
            send(name);
            isrunning = true;
        } catch (IOException e) {
            System.out.println("你构建的时候出错了(＾Ｕ＾)ノ~ＹＯ");
            this.release();
        }

    }

    //释放资源
    private void release(){
        this.isrunning = false;
        CloseClass.close(dos, client);//封装
    }

    //从控制台获取
    private String getFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            System.out.println("你获取信息的时候出错了(＾Ｕ＾)ノ~ＹＯ");
            this.release();
        }
        return null;
    }

    //发送消息
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("你发送的时候出错了(＾Ｕ＾)ノ~ＹＯ");
            this.release();
        }
    }
    @Override
    public void run() {
        while (isrunning){
            String msg = getFromConsole();
            if(!msg.equals(null)){
                send(msg);
            }
        }

    }
}
