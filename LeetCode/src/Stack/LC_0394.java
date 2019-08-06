package Stack;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LC_0394 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution.decodeString(s));
    }
}

class Solution {
    public String decodeString(String s) {
        Stack<Character> list = new Stack<>();
        int len = s.length();
        int i = 0;
        while(i < len){
            char c = s.charAt(i);
            if (c != ']') {
                list.push(c);
            }else {
                char ch = list.pop();
                String temp = "";
                while (ch != '['){
                    temp = temp + ch;
                    if(list.isEmpty()){
                        break;
                    }
                    ch = list.pop();
                }

                String cha = "";
                while(true){
                    if(list.isEmpty()){
                        break;
                    }
                    ch = list.pop();

                    if(ch >= '0' && ch <= '9'){
                        cha = ch + cha;
                    }
                    else if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch == '['){
                        list.push(ch);
                        break;
                    }else {
                        break;
                    }

                }
                int t = Integer.parseInt(cha);
                for( int rs = 0; rs < t; rs++) {
                    for (int j = temp.length() - 1; j >= 0; j--) {
                        list.push(temp.charAt(j));
                    }
                }
            }
            i++;
        }

        String temp = "";
        while(!list.isEmpty()){
            temp = list.pop() + temp;
        }
        return temp;
    }
}
