package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.Arrays;
import java.util.Set;

public class amazon_cloest_two_sum {
    public static void main(String[] args) {
        int[] nums = {5,10,9,20,16};
        int target = 20;
        amazon_cloest_two_sum sol = new amazon_cloest_two_sum();
        int answer = sol.closestTwoSum(nums,target);
        util.println(answer);
    }
    int closestTwoSum(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0,r = n-1;
        int maxValue = 0;
        while(l<r){
            if(nums[l]+nums[r] > target)
                r--;
            else{
                if(maxValue < nums[l]+nums[r])
                    maxValue = nums[l]+nums[r];
                l++;
            }
        }
        return maxValue;
    }
}
