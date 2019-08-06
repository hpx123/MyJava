package Thread_Text01;

import HashMap.TextHashMap;
import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema {

    public static void main(String[] args) {

        //可用位置
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);
        available.add(6);
        available.add(7);

        //顾客需要位置
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(4);
        seats2.add(5);
        Cinema m = new Cinema(available, "LoveCinema");
        new Thread(new Custmor(m, seats1), "LiXian").start();
        new Thread(new Custmor(m, seats2), "LiuHaoRan").start();

    }
}

class Custmor implements Runnable{

    private Cinema c;
    private List<Integer> seats;

    public Custmor(Cinema c, List<Integer> seats) {
        this.c = c;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (c) {
            boolean flag = c.cinema(seats);
            if (flag) {
                System.out.println("购票成功哦" + Thread.currentThread().getName() + seats);
            } else {
                System.out.println("购票失败");
            }
        }
    }
}

class Cinema{
    private List<Integer> available;
    private String name;

    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean cinema(List<Integer> seats){
        System.out.println("可用位置为" + available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);

        //相减
        copy.removeAll(seats);

        if(available.size() -  copy.size() != seats.size()){
            return false;
        }
        available = copy;
        return true;
    }
}
