package bling.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_47 {
    public static void main(String[] args){
        int[] nums = {1,1,3};
        leetcode_47 solution = new leetcode_47();

        List<List<Integer>> answers = solution.permuteUnique(nums);
        util.println(answers);
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums,answers,cur,used);
        return answers;
    }

    void helper(int[] nums,List<List<Integer>> answers, List<Integer> cur, boolean[] used){

        if(cur.size() == nums.length){
            answers.add(new ArrayList<>(cur));
            return;
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                // skip
                if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1])
                    continue;
                else{
                    cur.add(nums[i]);
                    used[i] = true;

                    helper(nums,answers,cur,used);

                    cur.remove(cur.size()-1);
                    used[i] = false;
                }

            }
        }
    }
}
