package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_973 {
    public static void main(String[] args) {
        leetcode_973 sol = new leetcode_973();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;
        int[][] ans = sol.kClosest_heap(points,K);
        for(int[] point:ans)
            util.println(Arrays.toString(point));
    }
    public int[][] kClosest_sort(int[][] points, int K) {
        Arrays.sort(points,(p1,p2) -> p1[0]*p1[0] + p1[1]*p1[1]
                                        -p2[0]*p2[0] -p2[1]*p2[1]);
        return Arrays.copyOfRange(points,0,K);
    }
    public int[][] kClosest_heap(int[][] points, int K) {
        class MyComparator implements Comparator<int[]>{
            @Override
            public int compare(int[] p1, int[] p2) {
                return - p1[0]*p1[0] - p1[1]*p1[1]
                        +p2[0]*p2[0] +p2[1]*p2[1];
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
        for(int[] point:points){
            if(pq.size() == K)
                pq.poll();
            pq.add(point);
        }
        int[][] ans = new int[K][2];
        int cur = 0;
        while(cur<K)
            ans[cur++] = pq.poll();
        return ans;
    }

}
