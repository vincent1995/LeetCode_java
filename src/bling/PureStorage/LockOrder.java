package bling.PureStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static bling.Leetcode.util.println;

public class LockOrder {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < 100000000; i++){
            list.add(i);
        }
        list.sort((a1,a2)->a1-a2);
    }
}
