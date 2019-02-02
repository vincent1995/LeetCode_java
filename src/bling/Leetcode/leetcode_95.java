package bling.Leetcode;

import bling.Leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_95 {
    public static void main(String[] args) {

    }
    public List<TreeNode> generateTrees(int n) {

        //create table
        List<TreeNode>[] table = new List[n+1];
        // init table
        for (int i = 0; i < n+1; i++) {
           table[i] = new ArrayList<>();
        }


        // DP process
        for (int i = 2; i <= n ; i++) {
            for (int j = 0; j < i; j++) {
                TreeNode rootNode = new TreeNode(j+1);
                // add left sub-tree
                for(TreeNode left: table[j]){
                    rootNode.left = left;
                    // add right sub-tree
                    for(TreeNode right: table[i-1-j]) {
                        rootNode.right = clone(right,j+1);
                    }
                }
            }
        }
        return table[n];
    }

    TreeNode clone(TreeNode node, int offset){
        if(node == null)
            return null;

        // self
        TreeNode newNode = new TreeNode(node.val+offset);
        // left
        newNode.left = clone(node.left,offset);
        // right
        newNode.right = clone(node.right,offset);

        return newNode;
    }

}
