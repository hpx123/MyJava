package LeetCode;

import java.util.Scanner;

public class LeetCode014 {

    public static String pubstr(String[] str){
        for(String m:str){
            if(m.length() == 0){
                return "";
            }
        }
        int i = 0;
        for(i = 0; i < str[0].length(); i++){

            char a = str[0].charAt(i);
            for(String m : str){
                if(m.length() == i || m.charAt(i) != a){
                    return m.substring(0, i);
                }
            }
        }
        return str[0].substring(0, i);
    }
    public static void main(String[] args){
        String[] str = new String[3];
        Scanner scan = new Scanner(System.in);
        int i = 0;
        for(i = 0; i < str.length; i++){
            String text = scan.next();
            str[i] = text;
        }
        System.out.println(pubstr(str));
    }
}
