/**
 * Terrible Problem, the matching rule is badly defined.
 */
package bling.Leetcode;

import java.util.regex.Pattern;

public class leetcode_65 {
    public static void main(String[] args){
        leetcode_65 sol = new leetcode_65();
        boolean ans = sol.isNumber(
                "1  ");
        util.println(ans);

    }

    /**
     * regular expression solution.
     * But can't use in this problem
     * @param s
     * @return
     */
    public boolean isNumberEP(String s) {
        String pattern = "(\\+|-)?(\\d+)(\\.\\d+)?(e(\\+|-)?\\d+)?";
        return Pattern.matches(pattern,s);
    }
    public boolean isNumber(String s) {
        int cur_index = 0;
        int n = s.length();
        int state = 0;

        while(cur_index < n){
            char ch = s.charAt(cur_index);
            switch(state){
                case 0: // init state
                    if(charIsSign(ch))
                        state = 1;
                    else if(charIsNumber(ch))
                        state = 2;
                    else if( ch == ' ')
                        state = 0;
                    else if(ch == '.'){
                        state = 9;
                    }
                    else
                        return false;
                    break;
                case 1: // begin with + or -
                    if(charIsNumber(ch))
                        state = 2;
                    else
                        return false;
                    break;
                case 2: // number before .
                    if(charIsNumber(ch))
                        state = 2;
                    else if(ch == '.')
                        state = 3;
                    else if(ch == 'e')
                        state = 5;
                    else if(ch == ' ')
                        state = 8;
                    else
                        return false;
                    break;
                case 3: // meet .
                    if(charIsNumber(ch))
                        state = 4;
                    else if(ch == ' ')
                        state = 8;
                    else
                        return false;
                    break;
                case 4: // numbers after .
                    if(charIsNumber(ch))
                        state = 4;
                    else if(ch == 'e')
                        state = 5;
                    else if(ch == ' ')
                        state = 8;
                    else
                        return false;
                    break;
                case 5: // meet e
                    if(charIsSign(ch))
                        state = 6;
                    else if(charIsNumber(ch))
                        state = 7;
                    else
                        return false;
                    break;
                case 6: // +/- after e
                    if(charIsNumber(ch))
                        state = 7;
                    else
                        return false;
                    break;
                case 7: // numbers after e
                    if(charIsNumber(ch))
                        state = 7;
                    else if(ch == ' ')
                        state = 8;
                    else
                        return false;
                    break;
                case 8: // final state
                    if( ch == ' ')
                        state = 8;
                    else
                        return false;
                case 9: // start with dot
                    if( charIsNumber(ch))
                        state = 4;
                    else
                        return false;
            }
            cur_index ++;
        }
        if(state == 0 || state == 1 || state == 5 || state == 6 || state == 9)
            return false;
        return true;
    }
    public boolean charIsSign(char ch){
        return ch == '+' || ch == '-';
    }

    public boolean charIsNumber(char ch){
        return (ch - '0') >= 0 && (ch -'0') <= 9;
    }
}
