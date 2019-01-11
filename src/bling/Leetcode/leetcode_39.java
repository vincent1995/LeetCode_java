/**
 * 思路： 暴力搜索，尝试所有组合。
 */
package bling.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_39 {

    public static void main(String[] args) {
        leetcode_39 m = new leetcode_39();
        int[] candidates = {1,2,3,4,5,6};
        List<List<Integer>> answers = m.combinationSum(candidates,10);

        for(List<Integer> answer : answers){
            System.out.println(answer);
        }
    }

    List<List<Integer>> answers = new ArrayList<>();
    ArrayList<Integer> curAns = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        oneSpot(candidates,candidates.length-1,target);
        return answers;
    }

    void oneSpot(int[] candidates, int start_point, int left){

        if(left == 0){
            answers.add(new ArrayList<>(curAns));
            return;
        }

        for(int i = start_point; i>=0 ; i--){
            if(candidates[i] <= left){
                curAns.add(candidates[i]);
                oneSpot(candidates,i,left-candidates[i]);
                curAns.remove(curAns.size()-1);
            }
        }
    }
}
