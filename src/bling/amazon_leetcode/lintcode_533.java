package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.Arrays;

public class lintcode_533 {
    public static void main(String[] args) {
        int[] nums ={-1, 2, 1, -4};
        int target = 4;
        lintcode_533 sol = new lintcode_533();
        int answer = sol.cloest2sum(nums,target);
        util.println(answer);
    }

    public int cloest2sum(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n-1;

        int minValue = Integer.MAX_VALUE;

        while(l<r){
            int dist = nums[l]+nums[r] -target;
            if(Math.abs(dist) < minValue){
                minValue = Math.abs(dist);
            }

            if(dist > 0)
                r--;
            else if(dist < 0 )
                l ++;
            else
                return 0;
        }
        return minValue;
    }
}
