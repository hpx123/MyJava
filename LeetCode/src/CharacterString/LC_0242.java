package CharacterString;

import java.util.Arrays;

public class LC_0242 {
    public static void main(String[] args) {

    }
}

class Polution {
    public boolean isAnagram(String s, String t) {
        char[] num = s.toCharArray();
        Arrays.sort(num);
        char[] nums = t.toCharArray();
        Arrays.sort(nums);
        String so = new String(num);
        String to = new String(nums);
        if (so.equals(to)) {
            return true;
        }
        return false;
    }
}