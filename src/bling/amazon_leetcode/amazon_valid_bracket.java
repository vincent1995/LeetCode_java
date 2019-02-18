package bling.amazon_leetcode;

import bling.Leetcode.util;

public class amazon_valid_bracket {
    public static void main(String[] args) {
        String str = "()()()((())))()";
        amazon_valid_bracket sol = new amazon_valid_bracket();
        int answer = sol.validBracket(str);
        util.println(answer);
    }
    int validBracket(String str){
        int n = str.length();
        if( n == 0)
            return 0;

        int cur = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch == '(')
                cur ++;
            else{
                cur --;
                count ++;
            }
            if(cur < 0)
                return -1;
        }
        if(cur != 0)
            return -1;
        return count;
    }
}
