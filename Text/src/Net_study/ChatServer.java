package Net_study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();

    public static void main(String[] args) throws IOException {
        System.out.println("---服务器已启动---");
        //1.指定端口，创建ServerSocket
        ServerSocket server = new ServerSocket(8888);
        //2.阻塞，等待连接accept
        while (true){
            Socket client = server.accept();//建立了一个客户端
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c);
            new Thread(c).start();
        }


    }

    //一个客户代表一个Channel
    static class Channel implements Runnable{
        private DataOutputStream dos = null;
        private DataInputStream dis = null;
        private Socket client;
        private boolean isrunning;
        private String name;

        public Channel(Socket client) {
            this.client = client;
            try {
                dos = new DataOutputStream(client.getOutputStream());
                dis = new DataInputStream(client.getInputStream());
                this.name = receive();
                this.send("杀马特一族欢迎你的加入...");//返回给你自己
                sendOthers("欢迎" + this.name + "加入杀马特家族", true);//返回给群聊
                isrunning = true;
            } catch (IOException e) {
                //如果有异常直接释放
                System.out.println("服务器端构建的时候出错了(＾Ｕ＾)ノ~ＹＯ");
                this.release();
            }
        }

        //接收消息
        private String receive(){
            String msg = "";//避免空指针
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("服务器端接受的时候出错了(＾Ｕ＾)ノ~ＹＯ");
                this.release();
            }
            return msg;
        }
        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("服务器端发送的时候出错了(＾Ｕ＾)ノ~ＹＯ");
                this.release();
            }
        }

        //发送群消息
        private void sendOthers(String msg, boolean isSys){
            boolean isPrivate = msg.contains("@");
            if(isPrivate){
                int index = msg.indexOf(":");
                String uname = msg.substring(1,index);
                msg = msg.substring(index + 1);
                for(Channel others: all){
                    if(others.name.equals(uname)){
                        others.send(this.name + "悄悄的对你说：" + msg);
                        break;
                    }

                }
            }else {
                for(Channel others: all){
                    if(others == this){
                        continue;//自己跳过自己
                    }
                    if(isSys){
                        others.send(this.name + "加入了群聊");
                        //系统公告
                    }
                    else {
                        others.send(this.name + "对所有人说：" + msg);
                        //群消息
                    }
                }
            }
        }
        //释放资源
        private void release(){
            this.isrunning = false;
            CloseClass.close(dos, dis, client);//封装
            //退出
            all.remove(this);
            sendOthers(this.name + "退出了杀马特家族...", true);
        }

        @Override
        public void run() {
            while (isrunning){
                String msg = receive();
                if(!msg.equals(null)){
                    sendOthers(msg, false);
                }
            }
        }
    }
}
