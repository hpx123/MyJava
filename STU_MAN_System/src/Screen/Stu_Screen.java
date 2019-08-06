package Screen;

import Server.Manager;
import Server.Student;

import java.util.Scanner;

public class Stu_Screen {
    public static void stuScreen(){
        Student stu = new Student();
        System.out.println("==============");
        System.out.println("已用用户：Y");
        System.out.println("注册：N");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        switch (choice){
            case "Y":
                stu.login();
                break;
            case "N":
                stu.register();
                break;
        }
    }
    public static void success(){
        Manager manager = new Manager();
        System.out.println("======学生页面======");
        System.out.println("1.查看本人信息");
        System.out.println("0.退出");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        switch (choice){
            case "1":

                break;
            case "2":
                break;
        }
    }
}
