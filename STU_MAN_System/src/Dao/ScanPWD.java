package Dao;

import java.util.Scanner;

public class ScanPWD {
    public static String scanID(){
        System.out.println("请输入用户名：");
        Scanner in = new Scanner(System.in);
        String id = in.nextLine();
        return id;
    }

    public static String scanPWD(){
        System.out.println("请输入密码");
        Scanner in = new Scanner(System.in);
        String pwd = in.nextLine();
        return pwd;
    }

}
