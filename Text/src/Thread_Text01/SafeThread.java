package Thread_Text01;

public class SafeThread {
    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web,"李现").start();
        new Thread(web,"田正国").start();
        new Thread(web, "金泰亨").start();


    }
}
class Web12306 implements Runnable{

    private int Tickets = 10;
    private boolean flag = true;

    @Override

    public void run() {
        while(flag){
            if(Tickets < 0){
                break;
            }

            text();
        }
    }
    public synchronized void text() {
        if (Tickets < 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + Tickets--);
    }
}
