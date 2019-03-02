package bling.PureStorage;

import bling.Leetcode.util;

public class PalindomeSubStringNumber {
    public static void main(String[] args) {
        String input = "hellolle";
        PalindomeSubStringNumber sol = new PalindomeSubStringNumber();
        int answer = sol.count_palindomes(input);
        util.println(answer);
    }

    int count_palindomes(String input){
        //edge case
        int n = input.length();
        if(n==0) return 0;

        int count = 0;

        // create table
        // table[i][j] means whether input[i:j] is a palindome
        boolean[][] table = new boolean[n][n];

        // init table
        for(int i = 0; i< n; i++){
            table[i][i] = true;
            count ++;
        }
        for(int i = 0; i<n-1; i++){
            if(input.charAt(i) == input.charAt(i+1)){
                table[i][i+1] = true;
                count ++;
            }
        }

        // DP
        for(int i = n-1; i >= 0; i--){
            for(int j = i+2; j < n; j++){
                if(table[i+1][j-1] && input.charAt(i) == input.charAt(j)){
                    table[i][j] = true;
                    count ++;
                }
            }
        }

        return count;
    }
}
