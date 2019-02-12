package bling.amazon_leetcode;


import bling.Leetcode.util;

import java.util.*;

public class leetcode_819 {
    public static void main(String[] args) {
        String p =  "Bob. hIt, baLl";
        String[] banWord = {"bob", "hit"};
        leetcode_819 sol = new leetcode_819();
        String ans = sol.mostCommonWord(p,banWord);
        util.println(ans);
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W"," ").
                toLowerCase().split("\\s+");
        // count
        for(String word:words){
            if(!ban.contains(word))
                count.put(word,count.getOrDefault(word,0)+1);
        }

        // get max
        return Collections.max(count.entrySet(),Map.Entry.comparingByValue()).getKey();
    }

}
