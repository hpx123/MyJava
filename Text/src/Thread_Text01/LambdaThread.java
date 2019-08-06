package Thread_Text01;

/**
 * lambda简化简单的线程
 * lambda是一个表达式
 */
//如果LambdaThread未被编辑那么new Thread(new Text()).start();就不会被使用后
public class LambdaThread  {
    //静态内部类
    static class Text implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                System.out.println("李现是我男朋友");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Text()).start();
        //局部内部类
        class Text02 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("李现是我小三");
                }
            }
        }
        new Thread(new Text02()).start();

        //匿名内部类 必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("李现是我老公");
                }
            }
        }).start();

        //jdk8简化 lambda
        //推倒只能用一个方法
        new Thread(()-> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("李现是我老公");
                }
            }
        ).start();

    }

}
