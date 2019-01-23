package bling.Leetcode;

public class leetcode_60 {
    public static void main(String[] args){
        leetcode_60 sol = new leetcode_60();
        String ans = sol.getPermutation(5,5);
        util.println(ans);
    }
    public String getPermutation(int n, int k) {

        int[] answer = new int[n];
        for(int i = 0;i< n;i++){
            answer[i] = i+1;
        }
        helper(answer, n, k-1, 0);
        // convert array to string
        String s = "";
        for (int i = 0; i < n; i++) {
            s += Integer.toString(answer[i]);
        }
        return s;
    }

    void helper(int[] answer, int n, int k, int start_pos){
        // count at answer[start_pos], which element should use
        int step_reduce = 1;
        for(int i = 1; i < n - start_pos;i++){
            step_reduce *= i;
        }
        int shift = 0;
        while(k>= step_reduce){
            k = k- step_reduce;
            shift ++;
        }
        // make the change;
        int target_val = answer[start_pos+shift];
        for( int i = start_pos+shift; i >start_pos;i--){
            answer[i] = answer[i-1];
        }
        answer[start_pos] = target_val;
        if(k>0)
            helper(answer,n,k,start_pos+1);
        return;
    }
}
