package Thread_Text01;

/**
 * 静态代理
 * 1、真实角色
 * 2、代理角色
 * 需要实现相同的接口
 */
public class StaticProxy {

    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
        //new Thread(线程对象).start();
    }
}

interface Marry{
    void happyMarry();
}

class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("我 and 李现 终于结婚了");
    }
}
//代理 角色
class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready() {
        System.out.println("李现洗澡");
    }

    private void after(){
        System.out.println("李现脱衣");
    }
}