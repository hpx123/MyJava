package Screen;

import Server.Manager;

import java.util.Scanner;

public class Main_Screen {
    public static void main(String[] args) {
        Manager ma = new Manager();
        Stu_Screen ss = new Stu_Screen();
        System.out.println("======学生管理系统======");
        System.out.println("======1.管理员用户======");
        System.out.println("======2.学生用户========");
        System.out.println("======3.退出============");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                ma.login();
                break;
            case 2:
                ss.stuScreen();
                break;
            case 3:
                break;
        }
    }

}
