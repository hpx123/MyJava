package Screen;

import Dao.ManDao;
import Server.Manager;

import java.util.Scanner;

public class Man_Screen {

    public static void manScreen(){
        ManDao md = new ManDao();
        System.out.println("======1.查询学生信息=======");
        System.out.println("======2.添加学生信息=======");
        System.out.println("======3.修改学生信息=======");
        System.out.println("======4.删除学生信息=======");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
