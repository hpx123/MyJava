package Thread_Text01;

/**
 * 创建线程
 * 方法：继承Thread+重写run
 */
public class StartThread extends Thread{
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("李现喜欢我");
        }
    }

    public static void main(String[] args){
        //启动线程
        /*
        1.创建子类对象，调用子类对象的start方法
         */
        StartThread sr = new StartThread();
        sr.start();
        for(int i = 0; i < 10; i++){
            System.out.println("刘昊然也喜欢我");
        }
    }
}
