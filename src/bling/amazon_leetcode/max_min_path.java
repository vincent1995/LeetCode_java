package bling.amazon_leetcode;

import bling.Leetcode.util;

public class max_min_path {
    public static void main(String[] args) {
        int[][] matrix = {
                {8,4,3,5},
                {6,5,9,8}
        };
        max_min_path sol = new max_min_path();
        int answer = sol.maxMinPath(matrix);
        util.println(answer);
    }

    /**
     * Use DP
     * @param matrix
     * @return
     */
    int maxMinPath(int[][] matrix){

        // edge case
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        if(n == 0)
            return 0;

        // create table
        int[][] table = new int[m][n];

        // init table
        {
            int min = Integer.MAX_VALUE;
            for(int i = 0;i< m;i++){
                min =  Math.min(min,matrix[i][0]);
                table[i][0] = min;
            }
        }
        {
            int min = Integer.MAX_VALUE;
            for(int i = 0;i< n;i++){
                min =  Math.min(min,matrix[0][i]);
                table[0][i] = min;
            }
        }

        // DP process
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                table[i][j] = Math.min(matrix[i][j],Math.max(table[i-1][j],table[i][j-1]));
            }
        }
        return table[m-1][n-1];
    }
}
