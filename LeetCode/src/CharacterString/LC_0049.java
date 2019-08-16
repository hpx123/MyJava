package CharacterString;

import java.util.*;

public class LC_0049 {
    public static void main(String[] args) {
        Solution so = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(so.groupAnagrams(strs));
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int i = 0, len = strs.length;
        for(String s:strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if( !map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}