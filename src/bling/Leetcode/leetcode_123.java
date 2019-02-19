package bling.Leetcode;

import static bling.Leetcode.util.println;

public class leetcode_123 {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        leetcode_123 sol = new leetcode_123();
        int answer = sol.maxProfit(prices);
        println(answer);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;

        int[] biggest = findMax(prices,0,n-1);
        if(biggest[0] == 0)
            return 0;

        int[] left = findMax(prices,0,biggest[1]);
        int[] right = findMax(prices,biggest[2],n-1);

        return Math.max(left[0],right[0]) + biggest[0];
    }
    int[] findMax(int[] prices, int l,int r){
        int maxL = r;
        int maxR = r;
        int curR = r;
        for(int i = r-1; i >= l; i--){
            if(prices[i] > prices[curR]){
                curR = i;
            }
            else if(prices[curR] - prices[i] > prices[maxR] - prices[maxL] ){
                maxR = curR;
                maxL = i;
            }
        }
        return new int[]{prices[maxR] - prices[maxL] ,maxL,maxR};
    }
}
