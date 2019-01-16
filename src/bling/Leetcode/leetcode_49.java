package bling.Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_49 {
    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        leetcode_49 solution = new leetcode_49();
        List<List<String>> answers = solution.groupAnagrams(strs);
        util.println(answers);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sort_str = new String(chars);
            if(map.containsKey(sort_str)){
                map.get(sort_str).add(str);
            }else{
                map.put(sort_str,new ArrayList<>());
                map.get(sort_str).add(str);
            }
        }
        List<List<String>> answers = new ArrayList<>();
        for(List<String> value : map.values()){
            answers.add(value);
        }
        return answers;
    }
}
