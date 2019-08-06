package Net_study;

import java.io.*;
import java.net.Socket;

public class loginClient {
    public static void main(String[] args) throws IOException {
        //1.建立连接：使用Socket创建客户端+服务的地址和端口
        Socket client = new Socket("localhost",9999);
        new Send(client).sent();
        new Receive(client).receive();
        //3.释放
        client.close();
    }
    //发送
    static class Send{
        //2.操作：输入流和输出流操作
        private DataOutputStream dos;
        Socket client;
        private BufferedReader console;
        private String str;

        public Send(Socket client){
            console = new BufferedReader(new InputStreamReader(System.in));
            this.client = client;
            this.str = insin();
            try {
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String insin(){
            try {
                System.out.print("请输入用户名");
                String upname = console.readLine();
                System.out.print("请输入密码");
                String upwd = console.readLine();
                return "upname="+upname+"&"+"upwd=" + upwd;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";

        }
        public void sent(){
            try {
                dos.writeUTF(str);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //接受
    static class Receive{
        private DataInputStream dis;
        private Socket client;

        public Receive(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(new DataInputStream(client.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void receive(){
            String str = null;
            try {
                str = dis.readUTF();
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
