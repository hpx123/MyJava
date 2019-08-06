package Server;

import Dao.ManDao;
import Dao.ScanPWD;
import Screen.Main_Screen;
import Screen.Man_Screen;

public class Manager {
//管理员登陆
    public static void login(){
        ManDao manDao = new ManDao();
        Man_Screen man_screen = new Man_Screen();
        ScanPWD scanPWD = new ScanPWD();
        String name = scanPWD.scanID();
        String pwd = scanPWD.scanPWD();
        if(manDao.manJudge(name,pwd))
        {
            System.out.println("登陆成功");
            man_screen.manScreen();

        }else {
            System.out.println("登陆失败");
        }
    }
}
