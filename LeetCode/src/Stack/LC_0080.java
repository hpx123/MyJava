package Stack;

import java.util.ArrayList;
import java.util.List;

public class LC_0080 {
    public static void main(String[] args) {
        Polution po = new Polution();
        int[] nums = {0,0,1,1,2,2,2,3,3,3,3};
        System.out.println(po.removeDuplicates(nums));
    }
}
class Polution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num: nums){
            if(i < 2 || num > nums[i - 2]){
                nums[i++] = num;
            }
        }
        return i;
    }
}
