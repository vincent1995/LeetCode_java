package bling.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        int[] candidates = {2,3,5,4,5,6,4,8,6,7};
        HashSet<Integer> set = new HashSet<>();
        for(int i : candidates){
            set.add(i);
        }
        ArrayList<Integer> candidates2 = new ArrayList<>();
        for(int i : set){
            candidates2.add(i);
        }
        System.out.println(candidates2.toString());
    }
}
