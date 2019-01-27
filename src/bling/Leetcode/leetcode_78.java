package bling.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_78 {
    public static void main(String[] args) {
        leetcode_78 sol = new leetcode_78();
        int[] nums = {1,2,3};
        List<List<Integer>> answers = sol.subsets(nums);
        util.println(answers);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers =  new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int pos = 0;
        helper(answers, cur, nums, pos);
        return answers;
    }

    void helper(List<List<Integer>> answers, List<Integer> cur, int[] nums, int pos){
        if( pos == nums.length){
            answers.add(new ArrayList<>(cur));
            return;
        }
        // include
        cur.add(nums[pos]);
        helper(answers,cur,nums,pos+1);
        cur.remove(cur.size()-1);
        // not include
        helper(answers,cur,nums,pos+1);
    }
}
