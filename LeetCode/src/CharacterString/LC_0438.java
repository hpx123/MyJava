package CharacterString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0438 {
    public static void main(String[] args) {
        Llution ll = new Llution();
        String s = "abac";
        String p = "b";
       System.out.println(ll.findAnagrams(s,p));
    }
}

class Llution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[123];
        int[] nump = new int[123];
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        int k = p.length(), end = p.length();
        if(s.length() < p.length()){
            return list;
        }
        for(int i = 0; i < k; i++){
            nump[chp[i]]++;
            nums[chs[i]]++;
        }
        while(k <= s.length()){
            boolean flag = true;
            for(int j = 97; j < 123; j++){
                if(nums[j] != nump[j]){
                    flag = false;
                }
            }
            if (flag){
                list.add(k - end);
            }if(k == s.length()){
                break;
            }
            nums[chs[k - end]]--;
            nums[chs[k]]++;
            k++;
        }
        return list;
    }
}