package Thread_Text01;

public class Tickets implements Runnable{
    private int ticketNums = 99;
    @Override
    public void run() {
        while(true){
            if(ticketNums < 0){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }

    public static void main(String[] args){
        //一份资源
        Tickets daili = new Tickets();

        new Thread(daili, "李现").start();
        new Thread(daili, "刘昊然").start();
        new Thread(daili, "田正国").start();
    }
}
