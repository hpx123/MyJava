package Stack;

import java.util.List;
import java.util.Stack;

public class LC_0856 {
    public static void main(String[] args) {
        Colution co = new Colution();
        System.out.println(co.scoreOfParentheses("()(())"));
    }
}
class Colution {
    public int scoreOfParentheses(String S) {
        Stack<String> list = new Stack<>();
        int i = 0, len = S.length();
        while(i < len){
            char c = S.charAt(i);
            if(c != ')'){
                list.push(c + "");
            }
            else {
                if(!list.empty() && list.peek().equals("(")) {
                    list.pop();
                    list.push("1");
                }
                else {
                    int sum = 0;

                    while (!list.peek().equals("(") && !list.isEmpty()) {
                        String tem = list.pop() + "";
                        sum += Integer.valueOf(tem);
                    }
                    if(!list.empty()) {
                        list.pop();
                    }
                    list.push(sum*2 + "");
                }
            }
            i++;
        }
        int ans = 0;
        for(String tem:list){
            ans += Integer.valueOf(tem);;
        }
        return ans;
    }
}