package bling.Leetcode;

import static bling.Leetcode.util.println;

public class leetcode_137 {
    public static void main(String[] args) {
        int targetTime = 5; // only target appear times
        int otherTime = 10; // other's appear times
        int nums[] = {  1,1,1,1,1,1,1,1,1,1,
                        2,2,2,2,2,2,2,2,2,2,
                        4,4,4,4,4,
                        3,3,3,3,3,3,3,3,3,3
                        };
        int[] digit = new int[4];

        for(int num: nums){
            int carry = num;
            for(int i = 0; i < digit.length; i++){
                int newCarry = carry & digit[i];
                digit[i] ^= carry;
                carry = newCarry;
            }
            int clear = digit[1] & digit[3];
            digit[0] &= ~clear;
            digit[2] &= ~clear;
        }
        println(digit[0]&digit[2]);
    }
}
