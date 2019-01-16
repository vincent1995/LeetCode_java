package bling.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_46 {

    public static void main(String[] args){
        leetcode_46 solution = new leetcode_46();
        int[] nums = {1,2,3};
        List<List<Integer>> answers =  solution.permute(nums);
        util.println(answers);
    }


    List<List<Integer>> answers = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        ArrayList<Integer> left = new ArrayList<>();
        for(int i:nums)
            left.add(i);
        helper(left);
        return answers;
    }

    void helper(ArrayList<Integer> left){
        if(left.size() == 0){
            answers.add(new ArrayList<>(cur));
            return;
        }
        else{
            for(Integer i : left){
                cur.add(i);
                ArrayList<Integer> new_left = (ArrayList<Integer>) left.clone();
                new_left.remove(i);
                helper(new_left);
                cur.remove(cur.size()-1);
            }
        }
    }

}
