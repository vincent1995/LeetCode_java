package bling.Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_84 {
    public static void main(String[] args) {
        int[] heights = {4,2,0,3,2,5};
        leetcode_84 sol =new leetcode_84();
        util.println(sol.largestRectangleAreaWithStack(heights));
    }

    /**
     * 扫描法
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // scan right
        int[] right = new int[n];
        right[n-1] = 0;
        for(int i = n-2;i>=0;i--){
            // right side is higher, can't spand
            if(heights[i] > heights[i+1])
                right[i] = 0;
            else{
                int j = i+1;
                while(j < n && heights[i] <= heights[j])
                    j = j + right[j] + 1;
                right[i] = j-i-1;
            }
        }

        // scan left
        int[] left = new int[n];
        left[0] = 0;
        for(int i = 1;i<n;i++){
            if(heights[i] > heights[i-1])
                left[i] = 0;
            else{
                int j = i-1;
                while(j >=0 && heights[i] <= heights[j])
                    j = j-left[j] -1;
                left[i] = i-j -1;
            }
        }

        util.println(Arrays.toString(left));
        util.println(Arrays.toString(right));
        // cal area
        int max_area = 0;
        for(int i = 0;i<n ;i++){
            int width = right[i] + left[i] +1;
            int area = width * heights[i];
            if(area > max_area)
                max_area = area;
        }
        return max_area;
    }

    /**
     * 辅助栈法
     *
     * 栈中存放左边界，当前元素是右边界
     * @param heights
     * @return
     */
    public int largestRectangleAreaWithStack(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;

        for (int i = 0; i < n; i++) {
            if(!stack.empty() && heights[i] < heights[stack.peek()]){
                // current bar is lower than bar in the top of stack
                // remove bar from stack until bar at top is shorter.
                while(!stack.empty() && heights[i] < heights[stack.peek()]){
                    // calculate stack top bar, then pop it
                    int index = stack.pop();
                    int area = heights[index] * (stack.empty()? i:(i-stack.peek()-1));
                    if(area> max_area)
                        max_area = area;
                }
            }
            stack.push(i);
        }
        while(!stack.empty()){
            while(!stack.empty()){
                // calculate stack top bar, then pop it
                int index = stack.pop();
                int area = heights[index] * (stack.empty()? n:(n-stack.peek()-1));
                if(area> max_area)
                    max_area = area;
            }
        }
        return max_area;
    }
}
