package bling.Leetcode;

import java.util.Arrays;

public class leetcode_75 {
    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};
        leetcode_75 sol = new leetcode_75();
        sol.sortColors(nums);
        util.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        // edge case
        int n = nums.length;
        if(n == 0)
            return;

        // sort
        int next_zero = 0;
        int cur = 0;
        int next_two = n-1;

        while(cur <= next_two){
            if(nums[cur] == 0){
                nums[cur] = 1;
                nums[next_zero] = 0;
                next_zero ++;
                cur++;
            }else if(nums[cur] == 1){
                cur++;
            }else if(nums[cur] == 2){
                if(nums[next_two] == 0){
                    nums[next_two] = 2;
                    nums[next_zero] = 0;
                    next_two --;
                    next_zero ++;
                    cur++;
                }else if(nums[next_two] == 1){
                    nums[next_two] = 2;
                    nums[cur] = 1;
                    next_two--;
                    cur++;
                }else if(nums[next_two] == 2){
                    next_two --;
                }
            }
        }
    }
}
