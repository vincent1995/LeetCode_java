package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class lintcode_613 {
    public static void main(String[] args) {
        int[][] scores = {{1,90},{1,50},{1,60},{1,90},{1,100},{1,70},{2,20},{2,30}};
        lintcode_613 sol = new lintcode_613();
        double[] answers = sol.average(scores);
        util.println(Arrays.toString(answers));
    }
    public double[] average(int[][] scores){
        Arrays.sort(scores,(a1,a2)-> (a1[0] - a2[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        int n = scores.length;
        int count = 0;
        ArrayList<Double> answers  = new ArrayList<>();
        while(index <= n){
            // change student
            if(index == n || index>0 && scores[index][0] != scores[index-1][0] ){
                // calcuate average
                int total = 0;
                for(Integer i:heap){
                    total += i;
                }
                heap.clear();
                answers.add((double)total/count);
                count = 0;
            }
            if(index < n){
                // add into queue
                heap.add(scores[index][1]);
                count++;
                if(count > 5){
                    heap.poll();
                    count--;
                }
            }
            index++;
        }
        double[] rtn = new double[answers.size()];
        for(int i = 0;i<answers.size();i++){
            rtn[i] = answers.get(i);
        }
        return rtn;
    }
}
