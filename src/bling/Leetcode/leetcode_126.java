package bling.Leetcode;

import java.util.*;

public class leetcode_126 {
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // map from Word to Index
        Map<String,Integer> words = new HashMap<>();
        for(int i = 0; i<wordList.size(); i++ )
            words.put(wordList.get(i),i);

        // available word set
        boolean[] visited = new boolean[wordList.size()];

        // init queue
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> startList = new ArrayList<>();
        startList.add(-1);
        queue.add(startList);

        List<List<String>> answers = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;

        //BFS
        while(queue.size() > 0){
            List<Integer> list = queue.poll();
            // check length
            if(list.size() > minLength)
                continue;
            // get last word
            int index = list.get(list.size()-1);
            String lastWord;
            if(index == -1)
                lastWord = beginWord;
            else{
                lastWord = wordList.get(index);
            }
            // if equal, stop
            if(lastWord.equals(endWord)){
                minLength = list.size();
                List<String> answer = new ArrayList<>();
                for(int i = 0; i < list.size(); i++){
                    int iindex = list.get(i);
                    if(iindex == -1)
                        answer.add(beginWord);
                    else
                        answer.add(wordList.get(iindex));
                }
            }
            // try replace
            StringBuffer word = new StringBuffer(lastWord);
            for(int i = 0; i < lastWord.length(); i++){
                char origin = word.charAt(i);
                for(char ch = 'a'; ch <= 'z'; ch++){
                    word.setCharAt(i,ch);
                    if(words.containsKey(word.toString())){
                        int newIndex = words.get(word.toString());
                        if(!visited[newIndex]){
                            visited[newIndex] = true;
                            List<Integer> newList = new ArrayList<>(list);
                            newList.add(newIndex);
                            queue.add(newList);
                        }
                    }
                }
                word.setCharAt(i,origin);
            }
        }
        return answers;
    }
}
