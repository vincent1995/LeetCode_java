package bling.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_51 {
    public static void main(String[] args){
        leetcode_51 solution = new leetcode_51();
        List<List<String>> answers = solution.solveNQueens(8);
        util.println(answers);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answers = new ArrayList<>();
        List<char[]> cur = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = '.';
            }
            cur.add(row);
        }
        helper(answers,cur,0);
        return answers;
    }
    void helper(List<List<String>> answers, List<char[]> cur, int i){
        if(i == cur.size()){
            List<String> new_answer = new ArrayList<>();
            for(char[] chars:cur){
                new_answer.add(new String(chars));
            }
            answers.add(new_answer);
            return;
        }else{
            for (int j = 0; j < cur.size(); j++) {
                cur.get(i)[j] = 'Q';
                if(isValid(cur,i,j))
                    helper(answers,cur,i+1);
                cur.get(i)[j] = '.';
            }
        }
    }
    boolean isValid(List<char[]> cur, int x, int y){
        int n = cur.size();
        // check row
        for(int j = 0; j< cur.size();j++){
            if(j!=y && cur.get(x)[j] == 'Q')
                return false;
        }
        // check column
        for(int i = 0; i< cur.size();i++){
            if(i!=x && cur.get(i)[y] == 'Q')
                return false;
        }

        // check diagonal

        // up left
        int cur_x = x-1,cur_y = y-1;
        while(cur_x>=0 && cur_y >=0){
            if(cur.get(cur_x)[cur_y] == 'Q')
                return false;
            cur_x--;
            cur_y--;
        }

        // up right
        cur_x = x-1;cur_y = y+1;
        while(cur_x>=0 && cur_y < n){
            if(cur.get(cur_x)[cur_y] == 'Q')
                return false;
            cur_x--;
            cur_y++;
        }

        // down left
        cur_x = x+1;cur_y = y-1;
        while(cur_x<n && cur_y >=0){
            if(cur.get(cur_x)[cur_y] == 'Q')
                return false;
            cur_x++;
            cur_y--;
        }
        // down right
        cur_x = x+1;cur_y = y+1;
        while(cur_x<n && cur_y <n){
            if(cur.get(cur_x)[cur_y] == 'Q')
                return false;
            cur_x++;
            cur_y++;
        }
        return true;
    }
}
