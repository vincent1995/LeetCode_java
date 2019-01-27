package bling.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        leetcode_76 sol = new leetcode_76();
        String ans = sol.minWindow(s,t);
        util.println(ans);
    }

    /**
     * In t, there are duplicated char.
     */
    HashMap<Character,Integer> counter = new HashMap<>();
    public String minWindow(String s, String t) {
        // edge case
        int n = s.length();
        if( n == 0)
            return s;
        int m = t.length();
        if( m == 0)
            return "";

        // count
        // init
        int head = 0, tail = 0;
        int min_length = n;
        int best_head = 0,best_tail  = n;
        int char_left = m;

        // scan string t
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            addCounter(ch);
        }

        // scan string s
        while(tail < n){
            // put tail in
            char ch = s.charAt(tail);
            tail++;
            if(counter.containsKey(ch)){
                int new_value = counter.get(ch)-1;
                counter.put(ch,new_value);
                if(new_value >= 0)
                    char_left --;
            }

            // when no char left ( all char included )
            if(char_left == 0){
                int length = tail - head;
                if(length < min_length){
                    min_length = length;
                    best_head = head;
                    best_tail = tail;
                }
            }

            // try dump head
            if(char_left == 0){
                while(true){
                    char ch_head = s.charAt(head);
                    if(counter.containsKey(ch_head)){
                        if(counter.get(ch_head) < 0){
                            addCounter(ch_head);
                            head++;
                            char_left++;
                        }else{
                            break;
                        }
                    }else{
                        head++;
                    }
                }
            }
        }
        return s.substring(best_head,best_tail);
    }

    int addCounter(char ch){
        if(!counter.containsKey(ch))
            counter.put(ch,0);
        int new_value = counter.get(ch)+1;
        counter.put(ch,new_value);
        return new_value;
    }

    int minusCounter(char ch){
        int new_value = counter.get(ch)-1;
        counter.put(ch,new_value);
        return new_value;
    }
}
