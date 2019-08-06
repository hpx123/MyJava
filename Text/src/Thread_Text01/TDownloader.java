package Thread_Text01;
/**
 * 图片下载
 */

public class TDownloader implements Runnable{
    private String usl;//远程路径
    private String name;//存储名字

    public TDownloader(String usl, String name) {
        this.usl = usl;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wb = new WebDownloader();
        wb.download(usl, name);

    }

    public static void main(String[] args){
        TDownloader td1 = new TDownloader("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E6%9D%8E%E7%8E%B0&step_word=&hs=0&pn=37&spn=0&di=71390&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2376069778%2C1780782684&os=222963560%2C311095316&simid=0%2C0&adpicid=0&lpn=0&ln=1564&fr=&fmq=1563842794320_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fp2.ifengimg.com%2Fa%2F2017_33%2F1a253fc38c24b69_size241_w1100_h900.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fjgp_z%26e3Btujg2_z%26e3Bv54AzdH3Ft15sgjofAzdH3Ffiwg2fijg2xtg2z75AzdH3FfrjvtwsAzdH3FstxtwgAzdH3F%23r%3Db&gsm=0&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "lixian01.jpg");
        TDownloader td2 = new TDownloader("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E6%9D%8E%E7%8E%B0&step_word=&hs=0&pn=59&spn=0&di=148170&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=3405719904%2C318751216&os=205580467%2C3221697137&simid=0%2C0&adpicid=0&lpn=0&ln=1564&fr=&fmq=1563842794320_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fp1.ifengimg.com%2Fcmpp%2F2017%2F08%2F03%2F15%2F2e4b49c4-7612-4513-8c92-5e4978a9b8c8_size114_w1020_h735.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fuwfit5g_z%26e3Btujg2_z%26e3Bv54AzdH3FwAzdH3Fda80abanAzdH3F9ad0mnl8_a_z%26e3Bfip4s%23r%3Dc&gsm=1e&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "lixian02.jpg");
        TDownloader td3 = new TDownloader("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E6%9D%8E%E7%8E%B0&step_word=&hs=0&pn=3&spn=0&di=147620&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=664950348%2C2191619512&os=1822937865%2C615573249&simid=0%2C0&adpicid=0&lpn=0&ln=1564&fr=&fmq=1563842794320_R&fm=&ic=undefined&s=undefined&hd=undefined&latest=undefined&copyright=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2Fallimg%2F171117%2F9-1G11G11035162.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bp7rtwgz3_z%26e3Bv54AzdH3Fztstw5AzdH3Fda808880AzdH3F8c89ab_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0&islist=&querylist=&force=undefined", "lixian03.jpg");

        new Thread(td1).run();
        new Thread(td2).run();
        new Thread(td3).run();


    }


}
