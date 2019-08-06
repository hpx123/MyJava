import java.util.*;

import static java.lang.Integer.valueOf;

@SuppressWarnings("all")
public class Calculate {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        List<Object> name = new ArrayList<>();
        CalculateText c = new CalculateText(name);
        c.calculate(str);
        c.Final(name);

    }



}
class CalculateText{
    List<Object> name = new ArrayList<>();
    int top = 0;
    char[] chars = new char[100];

    public CalculateText(List<Object> name) {
        this.name = name;
    }

    public  List<Object> calculate(String str) {
        int i = 0, j = 0;

        while (i < str.length()) {
            String s;
            String t = str;
            char c = str.charAt(i);
            if(c == '-' && i - 1 == -1){
                name.add("^");
                i++;
            }
            else if(c == '-' && (str.charAt(i-1) < '0' || str.charAt(i-1) > '9')){
                name.add("^");
                i++;
            }
            else if (c >= '0' && c <= '9'){
                j = i;
                while (c >= '0' && c <= '9') {
                    j++;
                    if (j >= str.length()){
                        break;
                    }
                    c = str.charAt(j);
                }
                s = t.substring(i, j);
                i = j;
                name.add(s);
                continue;
            } else {
                Char(c);
                i++;
            }
        }
        while(top >= 0 || chars[top] != 0){
            top--;
            if(top < 0){
                break;
            }
            name.add(chars[top]);
        }
        return name;

    }
    public int Change(char str) {
        int i;
        if(str == '+'){
            i = 1;
        }
        else if(str == '-'){
            i = 1;
        }
        else if(str == '*'){
            i = 2;
        }
        else if(str == '/'){
            i = 2;
        }
        else if(str == '('){
            i = 0;
        }
        else if(str == ')'){
            i = 4;
        }
        else {
            i = -1;
        }
//        switch (str) {
//            case '+': i = 1;
//            case '-': i = 1;
//            case '*': i = 2;
//            case '/': i = 2;
//            case '(': i = 4;
//            case ')': i = 0;
//            default:i = -1;
//                break;
//        }

        return i;
    }

    public boolean Compare(char a, char b){
       if(Change(a) > Change(b)){
           return true;
       }
       return false;
    }

    public void Char(char a){
        if(top == 0 && chars[0] == 0){
            chars[top] = a;
            top++;
        }
        else {
            if(a == ')'){
                while(true){
                    top--;
                    if(chars[top] == '('){
                        break;
                    }
                    name.add(chars[top]);
                }
                chars[top] = 0;
                return;
            }else if(Compare(a, chars[top - 1]) || a == '('){
                chars[top++] = a;
            }
            else {
                while(top >= 0){
                    --top;
                    if(top < 0){
                        break;
                    }
                    name.add(chars[top]);
                }
                //1name.add(chars[top]);
                top++;
                chars[top++] = a;
            }
        }
    }

    public void Final(List list){
        int i = 0;
        int len = 0;
        int[] m = new int[100];
         while (i < list.size()){
            String s = list.get(i) + "";
            if(isNumeric(s)){
                m[len++] = Integer.valueOf(s);
                i++;
            }
            else {
                if(s.equals("^")){
                    ++i;
                    s = list.get(i) + "";
                    m[len++] = Integer.valueOf(s);
                    m[len - 1] *= -1;
                }
               else if(s.equals("+")){
                    m[len - 2] = m[len - 2] + m[len - 1];
                    len -= 1;

                }
                else if(s.equals("-")){
                    m[len - 2] = m[len - 2] - m[len - 1];
                    len -= 1;
                }
                else if(s.equals("*")){
                    m[len - 2] = m[len - 2] * m[len - 1];
                    len -= 1;
                }
                else if(s.equals("/")){
                    m[len - 2] = m[len - 2] / m[len - 1];
                    len -= 1;
                }
                i++;
            }
         }
        System.out.println(m[0]);
    }
    public boolean isNumeric(String str){
        for (int i = str.length(); --i>=0; ){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

}




