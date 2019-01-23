package bling.Leetcode;

import java.util.Arrays;

public class leetcode_59 {
    public static void main(String[] args){
        leetcode_59 sol = new leetcode_59();
        int[][] answer = sol.generateMatrix(5);
        for(int[] s:answer){
            util.println(Arrays.toString(s));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int cur_val = 1;
        int x = 0;
        int y = 0;

        int left = 0;
        int right = n-1;
        int top = 0;
        int button = n-1;

        int direction = 0;

        while(cur_val < n*n){
            switch(direction){
                case 0:
                    if( y < right) {
                        matrix[x][y] = cur_val;
                        y++;
                        cur_val ++;
                    }else{
                        direction = 1;
                        top ++;
                    }
                    break;
                case 1:
                    if( x < button){
                        matrix[x][y] = cur_val;
                        x++;
                        cur_val ++;
                    }else{
                        direction = 2;
                        right --;
                    }
                    break;
                case 2:
                    if( y > left){
                        matrix[x][y] = cur_val;
                        y--;
                        cur_val ++;
                    }else{
                        direction = 3;
                        button --;
                    }
                    break;
                case 3:
                    if( x > top ){
                        matrix[x][y] = cur_val;
                        x--;
                        cur_val ++;
                    }else{
                        direction = 0;
                        left ++;
                    }
            }
        }
        matrix[x][y] = cur_val;
        return matrix;
    }
}
