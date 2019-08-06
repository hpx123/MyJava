package CharacterString;

import java.util.ArrayList;
import java.util.List;

public class LC_0003 {
    public static void main(String[] args) {
        Iolution io  = new Iolution();
        System.out.println(io.lengthOfLongestSubstring("pwwkew"));
    }

}
class Iolution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int r = 0, l = 0;
        if(s.length() == 0){
            return 0;
        }
        int[] index = new int[256];
        while(l < s.length()) {
            if(index[s.charAt(r)] == 0){
                index[s.charAt(r)]++;
                System.out.println(r + "--" + l);
                max = Math.max(max, r - l + 1);
                r++;
                if(r >= s.length()){
                    break;
                }
            }else {
                index[s.charAt(l)]--;
                l++;
            }
        }
        return max;
    }
}
