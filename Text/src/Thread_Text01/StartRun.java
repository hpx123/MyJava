package Thread_Text01;

/**
 * 创建线程方式二：
 * 1。创建：实现runnable+重写run
 * 2。启动：创建实现类对象+Thread对象+ start
 * 避免单继承的实现性
 */
//实现接口
public class StartRun implements Runnable{


    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println("一边看李现");
        }
    }
    public static void main(String[] args){
        //创建实现类对象
        StartRun sr = new StartRun();
        //创建代理类对象
        Thread t = new Thread(sr);
        //启动
        t.start();
        /**
         * 如果一个对象只使用一次:匿名
         * new Thread(new StartRun()).start();
         */
    }
}
