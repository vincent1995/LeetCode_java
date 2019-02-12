package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode_909 {
    public static void main(String[] args) {
        leetcode_909 sol = new leetcode_909();
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        int answer = sol.snakesAndLadders(board);
        util.println(answer);
    }

    // BFS iteration version
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] count = new int[n*n+1];

        // DFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int index = queue.poll();
            // try go 1 to 6
            for(int i = 6;i>0;i--){
                int newIndex = index+i;
                if(newIndex > n*n)
                    continue;
                int[] coor = getCoor(board,newIndex);
                int val = board[coor[0]][coor[1]];

                // have latter
                if(val > 0)
                    newIndex = val;

                if(newIndex == 1)
                    continue;

                // if count at newIndex bigger, update
                if(count[newIndex] == 0 || count[newIndex] > count[index]+1){
                    count[newIndex] = count[index]+1;
                    queue.add(newIndex);
                }
                // if count at newIndex is smaller, stop.
            }
        }

        if(count[n*n] == 0)
            return -1;
        else
            return count[n*n];
    }

    int[] getCoor(int[][]board, int num){
        int n = board.length;
        num = num -1;
        int row = num / n;
        int col = ( num % n);

        if( (row + 1) % 2 == 0)
            col = (n-1)-col;
        row = n-1-row;
        return new int[]{row,col};
    }
}
