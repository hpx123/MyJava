package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0015 {
    public static void main(String[] args) {
        Kolution ko = new Kolution();
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> lists = new ArrayList<>();
        lists = ko.threeSum(nums);
        for (List temp:lists){
            System.out.println(temp);
        }

    }
}
class Kolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int i, l, r, sum;
        Arrays.sort(nums);
        for(i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                l = i + 1;
                r = nums.length - 1;
                while (l < r){
                    sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0){
                        System.out.println(i+ "--"+l+"---"+r);
                        list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                    else if(sum > 0){
                        if(nums[r - 1] != nums[r]){
                            r--;
                        }else {
                            while (nums[r - 1] == nums[r]){
                                r--;
                                if(l == r){
                                    break;
                                }
                            }
                        }

                    }else {
                        if(nums[l + 1] != nums[l]){
                            l++;
                        }else {
                            while (nums[l + 1] == nums[l]){
                                l++;
                                if(l == r){
                                    break;
                                }
                            }
                        }
                        System.out.println(i+ "--"+l+"---"+r);
                    }
                }
            }
        }
        return list;
    }
}
