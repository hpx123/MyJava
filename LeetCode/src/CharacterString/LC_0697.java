package CharacterString;

import java.util.*;

public class LC_0697 {
    public static void main(String[] args) {
        Molution mo = new Molution();
        int[] nums = {8,9,8,9,8};
        System.out.println(mo.findShortestSubArray(nums));
    }
}

class Molution {
    public int findShortestSubArray(int[] nums) {
        int min = 0, maxLen = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer key = nums[i];
            if( !map.containsKey(key) ){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
            List<Integer> list = map.get(key);
            if(list.size() > maxLen){
                min = list.get(list.size() - 1) - list.get(0) + 1;
                maxLen = list.size();
            }else if(list.size() == maxLen){
                if(list.get(list.size() - 1) - list.get(0) + 1 < min){
                    min = list.get(list.size()) - list.get(0) + 1;
                }
            }
        }
        return min;
    }
}