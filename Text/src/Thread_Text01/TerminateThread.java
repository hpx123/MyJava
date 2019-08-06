package Thread_Text01;

public class TerminateThread implements Runnable {
    //加入标识 标识线程体是否继续运行
    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        //关联标识, true运行false停止
        while(flag){
            System.out.println(name + "--->"+ i++);
        }
    }

    //对外提供关联
    public void terminate(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("李现");
        new Thread(tt).start();

        for(int
            i = 0; i < 10; i++){
            if(i == 8){
                tt.terminate();//终止线程
                System.out.println("tt game over");
            }
            System.out.println("main" + i);
        }

    }
}
