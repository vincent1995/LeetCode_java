package bling.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_89 {
    public static void main(String[] args) {
        leetcode_89 sol = new leetcode_89();
        List<Integer> ans = sol.grayCode(5);
        util.println(ans);

    }

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        for(int i = 1;i<=n;i++){
            int size = ans.size();
            for(int j = size-1;j>=0;j--){
                ans.add(ans.get(j)+(1<<(i-1)));
            }
        }
        return ans;
    }
}
