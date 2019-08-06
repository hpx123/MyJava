package CoText;

/**
 * 管程法
 */

public class CoText01 {
    public static void main(String[] args) {

        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumor(container).start();
    }

}
//生产者
class Productor extends Thread{

    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
    //生产馒头
        for(int i = 0; i < 100; i++){
            System.out.println("生产了第" + i + "个馒头");
            container.push(new SteamBun(i));
        }
    }
}
// 消费者
class Consumor extends Thread{
    SynContainer container;

    public Consumor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
    //消费馒头
        for(int i = 0; i < 100; i++){
            System.out.println("消费了第" + container.pop().id + "个馒头");
        }
    }
}
// 缓冲区
class SynContainer{
   SteamBun[] buns = new SteamBun[10];
   int count = 0;//计数器
    //存储生产
    public synchronized void push(SteamBun bun){

        //何时生产，容器是否存在空间
        //不能生产，等待
        if(count == buns.length){
            try {
                this.wait();//线程阻塞，消费者通知生产解除
            } catch (InterruptedException e) {
            }
        }
        buns[count] = bun;
        count++;
        //存在数据了，可以通知对方消费
        this.notifyAll();
    }
    //取(取最后一个）
    public synchronized SteamBun pop(){
        //何时消费，容器中是否存在数据
        //没有数据，只有等待
        if(count == 0){
            try {
                this.wait();//线程阻塞，生产者通知消费者
            } catch (InterruptedException e) {
            }
        }

        //存在数据可以消费
        count--;
        SteamBun bun = buns[count];
        this.notifyAll();//有数据了， 可以唤醒对方生产
        return bun;
    }
}
// 馒头（数据）
class SteamBun{
    int id;

    public SteamBun(int id) {
        this.id = id;
    }
}