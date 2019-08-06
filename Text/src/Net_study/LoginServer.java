package Net_study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {

    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //1.指定端口，创建ServerSocket
        ServerSocket server = new ServerSocket(9999);
        boolean isRunning = true;
        //2.阻塞，等待连接accept
        while (isRunning){
            Socket client = server.accept();//建立了一个客户端
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
        //4.关闭
        server.close();
    }

    static class Channel implements Runnable{
        private Socket client;
        //3.操作：输入输出流操作
        private DataInputStream dis;
        private DataOutputStream dos;
        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    client.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        //接收数据
        private String recieve(){
            String data = null;
            try {
                data = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
        //发送数据
        private void send(String str){
            try {
                dos.writeUTF(str);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //释放资源
        private void release(){

            try {
                if(dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            String uname = "";
            String upwd = "";
            //分析
            String[] dataArray = recieve().split("&");
            for (String info: dataArray) {
                String[] upInfo = info.split("=");
                if(upInfo[0].equals("upname")){
                    System.out.println("你的用户名为：" + upInfo[1]);
                }
                else if(upInfo[0].equals("upwd")){
                    System.out.println("你的密码为：" + upInfo[1]);
                }
            }
            if(uname.equals("hucheng") && upwd.equals("1116bts")){
                send("登录成功");
            }else {
                send("登录失败");
            }
        }
    }
}
