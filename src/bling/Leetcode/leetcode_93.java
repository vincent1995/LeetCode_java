package bling.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_93 {
    public static void main(String[] args) {
        leetcode_93 sol = new leetcode_93();
        String input = "25525511135";
        List<String> answers = sol.restoreIpAddressesBruteForce(input);
        util.println(answers);
    }

    /**
     *  Version 1, backtrack
     */
    public List<String> restoreIpAddresses(String s) {
        // use backtrack

        List<String> answers = new ArrayList<>();
        int[] cur = {0,1,2,3};// the position of three dot
        help(answers,cur,s,3);
        return answers;
    }

    void help(List<String> answers, int[] cur, String s, int pos){
        if(pos == 0){

        }
        else{
            int n = s.length();
            int edge;

            if(pos == 3)
                edge = n;
            else
                edge = cur[pos+1];

            while(cur[pos] < edge){
                if(checkValid(s,cur,pos)){
                    help(answers,cur,s,pos-1);
                }
            }
        }
    }

    boolean checkValid(String s, int[] cur, int pos){
        String sub;
        if(pos < 3){
            sub = s.substring(cur[pos]);
        }
        else
            sub = s.substring(cur[pos]);
        int val = Integer.valueOf(sub);

        return val >= 0 && val <= 255;
    }

    /**
     * Version 2, brute force
     */
    public List<String> restoreIpAddressesBruteForce(String s) {
        List<String> answers = new ArrayList<>();
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if( check(s,0,i) && check(s,i,j) &&
                                check(s,j,k) && check(s,k,n))
                        answers.add(s.substring(0,i)+"."+
                                s.substring(i,j)+"."+
                                s.substring(j,k)+"."+
                                s.substring(k,n));
                }
            }
        }
        return answers;
    }
    boolean check(String s, int l, int r){
        if(r-l>3)
            return false;
        int val = Integer.valueOf(s.substring(l,r));
        return val >=0 && val <= 255;
    }

}
