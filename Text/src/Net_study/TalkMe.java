package Net_study;

public class TalkMe {
    public static void main(String[] args) {
        new Thread(new UDP_Talk_Client(7777, "localhost", 9999)).start();//发送
        new Thread(new UDP_Talk_Server(6666, "李现")).start();
    }
}
