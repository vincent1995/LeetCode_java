package bling.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_77 {
    public static void main(String[] args) {
        leetcode_77 sol = new leetcode_77();
        List<List<Integer>> answers = sol.combine(4,2);
        util.println(answers);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answers = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int start_point = 1;
        int round = 1;
        helper(answers,cur,1,n,1,k);
        return answers;
    }

    void helper(List<List<Integer>> answers, List<Integer> cur,
                int start_point,int end_point, int round,int max_round){

        if(round == max_round+1){
            answers.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = start_point; i <=  end_point; i++) {
            cur.add(i);
            helper(answers,cur,i+1,end_point,round+1,max_round);
            cur.remove(cur.size()-1);
        }
    }
}
