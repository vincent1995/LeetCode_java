package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.*;

public class leetcode_642 {
    public static void main(String[] args) {
        String[] strings = {
            "c","cc","ccc"
        };
        int[] count = {
                1,2,3
        };
        AutocompleteSystem sol = new AutocompleteSystem(strings,count);
        for(char ch:new char[]{
            'c','c','c','c','#','c','c','c','c','#','c','c','c','c','#','c','c'
        }){
            List<String> ans = sol.input(ch);
            util.println(ans);
        }
    }
}
class AutocompleteSystem {

    private class Record{
        String str;
        int count;
        Record(String s,int count){
            str = s;
            this.count = count;
        }
        void addCount(){
            count ++;
        }
    }

    private class TrieNode{
        TrieNode toSpace = null;
        TrieNode[] toChar = null;
        TrieNode(){
            stringsNum = new ArrayList<>();
        }
        List<Integer> stringsNum;
    }


    TrieNode trieRoot = new TrieNode();
    Map<String,Integer> stringExists = new HashMap<>();
    ArrayList<Record> strings = new ArrayList<>();
    TrieNode cur;
    ArrayList<Character> charHistory = new ArrayList<>();

    public AutocompleteSystem(String[] sentences, int[] times) {
        // initiate structure
        int n = sentences.length;
        for(int i = 0;i<n;i++){
            String sentence = sentences[i];
            int time = times[i];

            // add to ArrayList
            int index = strings.size();
            strings.add(new Record(sentence,time));

            // add to Map
            stringExists.put(sentence,index);

            // add to tireRoot
            addToTrie(trieRoot,sentence,index);
        }
        // init variable
        cur = trieRoot;
    }
    void addToTrie(TrieNode trieRoot,String sentence,int index){
        TrieNode last = trieRoot;
        for(int i = 0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            if( ch == ' '){
                if(last.toSpace  == null)
                    last.toSpace = new TrieNode();
                last = last.toSpace;
                last.stringsNum.add(index);
            }
            else{
                if(last.toChar == null)
                    last.toChar = new TrieNode[26];
                if(last.toChar[ch-'a'] == null)
                    last.toChar[ch-'a'] = new TrieNode();
                last = last.toChar[ch-'a'];
                last.stringsNum.add(index);
            }
            // remove some record from TrieNode.strings.Num;
        }
    }

    public List<String> input(char c) {
        if( c == '#'){
            // get string
            int length = charHistory.size();
            char[] chars = new char[length];
            for(int i = 0;i<length;i++)
                chars[i] = charHistory.get(i);
            String s = new String(chars);

            //check existence
            if(stringExists.containsKey(s)){
                int index = stringExists.get(s);
                strings.get(index).addCount();
            }
            else{
                // add strings
                int index = strings.size();
                strings.add(new Record(s,1));

                // add to map
                stringExists.put(s,index);

                // add to trie
                addToTrie(trieRoot,s,index);
            }

            // reset global variable
            cur = trieRoot;
            charHistory.clear();

            return new ArrayList<>();
        }

        charHistory.add(c);

        if(cur == null)
            return new ArrayList<>();

        if( c == ' '){
            cur = cur.toSpace;
            if(cur == null)
                cur = new TrieNode();
        }
        else{
            if(cur.toChar == null)
                cur.toChar = new TrieNode[26];
            if(cur.toChar[c-'a'] == null)
                cur.toChar[c-'a'] = new TrieNode();
            cur = cur.toChar[c-'a'];
        }

        List<Integer> stringsIndex = cur.stringsNum;
        List<Integer> top3Index = getTop3String(stringsIndex);
        List<String> answer = new ArrayList<>();
        for(int i : top3Index){
            answer.add(strings.get(i).str);
        }
        return answer;
    }

    List<Integer> getTop3String(List<Integer> indexes){
        List<Record> records = new ArrayList<>();
        for(int i:indexes){
            records.add(strings.get(i));
        }
        records.sort(new RecordComparator());
        List<Integer> top3 = new ArrayList<>();
        int num = Math.min(3,records.size());
        for(int i = 0;i<num;i++)
            top3.add(stringExists.get(records.get(i).str));
        return top3;
    }
    class RecordComparator implements Comparator<Record>{

        @Override
        public int compare(Record o1, Record o2) {
            if(o1.count - o2.count == 0){
                return o1.str.compareTo(o2.str);
            }
            else{
                return -(o1.count-o2.count);
            }
        }
    }
}