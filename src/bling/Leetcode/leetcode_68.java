package bling.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_68 {
    public static void main(String[] args){
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        leetcode_68 sol = new leetcode_68();
        List<String> answers = sol.fullJustify(words,maxWidth);
        util.println(answers);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> answers = new ArrayList<>();

        // edge case
        if(words.length == 0)
            return answers;


        // init
        int start = 0;
        int cur = 1;
        int num_words = 1;
        int width = words[0].length();
        boolean last_round = false;

        while(true){
            if(cur < words.length && width+words[cur].length()+1 <= maxWidth){
                width = width + words[cur].length() + 1;
                cur++;
                num_words ++;
            }else{
                int space_num = maxWidth - width - num_words + 1;
                int gap_num = num_words -1;
                String newLine = "";
                for(int i = start;i<cur;i++){
                    newLine += words[i];
                    int space_in_gap = (int)Math.round((double)space_num/gap_num);
                    space_num -= space_in_gap;
                    gap_num --;
                    for (int j = 0; j < space_in_gap; j++) {
                        newLine += " ";
                    }
                }
                answers.add(newLine);
            }
            if(last_round)
                break;
            if(cur == words.length){
                last_round = true;
            }
        }
        return answers;
    }
}
