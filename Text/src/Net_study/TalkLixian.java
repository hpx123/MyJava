package Net_study;

import javax.management.MBeanAttributeInfo;

public class TalkLixian {
    public static void main(String[] args) {
        new Thread(new UDP_Talk_Server(9999, "胡胖胖")).start();//接收
        new Thread(new UDP_Talk_Client(5555, "localhost", 6666)).start();
    }
}
