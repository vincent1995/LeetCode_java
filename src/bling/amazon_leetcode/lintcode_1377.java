package bling.amazon_leetcode;

import java.util.HashSet;
import java.util.Set;

public class lintcode_1377 {
    public int findSubstring(String str, int k) {
        if(k == 0)
            return 1;

        int l = 0;
        int r = l+k;

        int n = str.length();


        Set<String> set = new HashSet<>();

        while( r<n ){
            String sub = str.substring(l,r);
            set.add(sub);
        }
        return set.size();

    }
}
