package bling.Leetcode;

import java.util.*;

public class leetcode_127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        leetcode_127 sol = new leetcode_127();
        int answer = sol.ladderLength(beginWord,endWord,wordList);
        util.println(answer);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<StringBuffer> curStrings = new LinkedList<>();
        Set<String> words = new HashSet<>();
        int round = 0;
        int count = 1;
        int newCount = 0;

        // construct dictionary
        for(String s:wordList){
            words.add(s);
        }

        // init queue
        curStrings.add(new StringBuffer(beginWord));

        while(curStrings.size() > 0){
            StringBuffer cur = curStrings.poll();
            if(cur.toString().equals(endWord))
                return round;
            else{
                // try replace one char
                for(int i = 0; i < cur.length(); i++){
                    char origin = cur.charAt(i);
                    for(char ch = 'a'; ch <='z';ch++){
                        cur.setCharAt(i,ch);
                        if(words.contains(cur.toString())){
                            newCount++;
                            curStrings.add(new StringBuffer(cur));
                            words.remove(cur.toString());
                        }
                    }
                    cur.setCharAt(i,origin);
                }
            }

            count--;
            if(count == 0){
                round ++;
                count = newCount;
                newCount = 0;
            }

        }
        return 0;
    }
}
