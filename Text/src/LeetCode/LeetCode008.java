package LeetCode;

import java.io.InputStream;
import java.util.Scanner;

public class LeetCode008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(str));
        if(solution.myAtoi(str) != 0){
            System.out.println(solution.myAtoi(str));
        }
        else{
            System.out.println("0");
        }
    }


}

class Solution {
    public int myAtoi(String str) {
        int i = 0, j = 0;
        boolean flag = true, pos = true;
        for(i = 0; i < str.length(); i++){
            char c  = str.charAt(i);
            while (c == ' ' && i == 0 && pos){
                i++;
                c  = str.charAt(i);
                if(c != ' ' || c == '-'){
                    flag = false;
                    pos = false;
                    break;
                }
                if(c != ' ' || c == '+' ){
                    pos = false;
                    break;
                }
            }
            if((c == '-'|| c == '+') && i == 0){
                if(c == '-'){
                    flag = false;
                }
            }

            else if(c >= '0' && c <= '9'){
                j = j * 10 + (c - '0');
            }
            else {
                break;
            }
        }
        System.out.println(j);
//        if(j > Integer.MIN_VALUE){
//            return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//        }
        if(!flag){
            j *= -1;
        }
        return j;
    }
}