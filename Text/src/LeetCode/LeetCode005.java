package LeetCode;

import java.util.Scanner;

public class LeetCode005 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(new solution().longestPalindrome(s));


    }
}
class solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] flag = new  boolean[len][len];
        int i =0 , j = 0, begin = 0, end = 0, maxLen = -1;

//        for(i = 0; i < len; i++){
//            for(j = i; j >= 0; j++){
//                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 ||flag[i+1][j-1])){
//                    flag[i][j] = true;
//                    System.out.println(maxLen);
//                    System.out.print(i + ",");
//                    System.out.println(j);
//                    if(maxLen < j - i + 1){
//                        maxLen = j - i + 1;
//                        begin = i;
//                        end = j;
//                    }
//                }
//            }
//        }
        return s.substring(begin, end);
    }
}
