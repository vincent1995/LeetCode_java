package bling.Leetcode;

public class leetcode_79 {
    public static void main(String[] args) {
        leetcode_79 sol = new leetcode_79();
        char[][] board =   {{'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}};
        String word = "ABCB";
        util.println(sol.exist(board,word));
    }
    public boolean exist(char[][] board, String word) {
        // edge case
        int m = board.length;
        if(m == 0)
            return false;
        int n = board[0].length;
        if( n == 0)
            return false;

        if(word.length() == 0)
            return true;

        boolean[][] mask = new boolean[m][n];
        char first_letter = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == first_letter){
                    mask[i][j] = true;

                    // start search
                    if(search(board,mask,word,i,j,1))
                        return true;
                    mask[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, boolean[][] mask, String word, int x, int y, int cur_char_index){
        if(cur_char_index == word.length())
            return true;

        // four direction from (x,y)
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < 4; i++) {
            int[] direction = directions[i];
            int new_x = x+direction[0];
            int new_y = y+direction[1];
            // check in bound
            if(new_x>=0 && new_x < m && new_y >=0 && new_y < n){
                // check not used
                if(board[new_x][new_y] == word.charAt(cur_char_index) && mask[new_x][new_y] == false){
                    // matched, start match for next char
                    mask[new_x][new_y] = true;
                    if(search(board, mask, word, new_x, new_y, cur_char_index+1))
                        return true;
                    mask[new_x][new_y] = false;
                }
            }
        }
        return false;
    }
}
