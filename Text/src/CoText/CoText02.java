package CoText;

import HashMap.TextHashMap;

public class CoText02 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Thread(new Player(tv)).start();
        new Thread(new watcher(tv)).start();
    }

}

//表演者
class Player extends Thread{
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0){
               this.tv.play("蜜汁炖鱿鱼");
            }
            else {
                this.tv.play("李现和胡程的浪漫生活");
            }
        }
    }
}
//观众
class watcher extends Thread{

    TV tv;

    public watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
           this.tv.watch();
        }
    }
}
//TV
class TV{
    String voice;
    boolean flag = true;

    public synchronized void play(String voice){
        //红灯，我在看电视，李现等待
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.voice = voice;
        System.out.println("李现表演了" + voice);

        //唤醒我
        this.notifyAll();
        flag = !flag;
    }

    public synchronized void watch(){
        //绿灯了， 李现在表演， 我等待
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.voice = voice;
        System.out.println("胡程观看了" + voice);
        //我看完了，唤醒李现让他表演
        this.notifyAll();
        flag = !flag;
    }
}