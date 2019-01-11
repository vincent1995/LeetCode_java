/**
 * 思路： 双指针，从两头开始取递增序列,计算所有block的总体积。
 *
 * 思路2： 两个值记录左右两边最大高度，根据最大高度和当前block高度计算水的体积。
 * link：https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
 */
package bling.Leetcode;

public class leetcode_42 {
    public static void main(String[] args){
        leetcode_42 lc = new leetcode_42();
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int size = lc.trap(input);
        System.out.println(size);
    }

    public int trap(int[] height) {
        int l = 0,r = height.length-1;
        int last_h = 0;
        int total_size = 0;

        // calculate total size;
        while(l<=r){
            // calculate the size
            int h = Math.min(height[l],height[r]);
            int raise = h-last_h;
            total_size += raise*(r-l+1);
            last_h = h;
            if(l==r)
                break;

            // move pointer
            if(height[l] == height[r]){
                int old_l = l;
                int old_r = r;
                while(l<r && height[l] <= height[old_l]) l++;
                while(l<r && height[r] <= height[old_r]) r--;
            }else if(height[l] < height[r]){
                int old_l = l;
                while(l<r && height[l] <= height[old_l]) l++;
            }else if(height[l] > height[r]){
                int old_r = r;
                while(l<r && height[r] <= height[old_r]) r--;
            }
        }

        // calculate block size
        int block_size = 0;
        for(int i : height){
            block_size += i;
        }

        // get rain size;
        int rain_size = total_size - block_size;
        return rain_size;
    }
}
