package bling.Leetcode;

import bling.Leetcode.util.TreeNode;

import java.util.Arrays;

public class leetcode_105 {
    public static void main(String[] args) {
        leetcode_105 sol = new leetcode_105();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode answer = sol.buildTree(preorder,inorder);
        return;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        int n = preorder.length;
        root = helper(preorder,inorder,0,n,0,n);
        return root;
    }

    TreeNode helper(int[] preorder, int[] inorder,int preBegin, int preEnd, int inBegin, int inEnd){

        //edge case
        if(preBegin>=preEnd)
            return null;

        int rootVal = preorder[preBegin];
        int index = inBegin;
        for(int i = inBegin; i < inEnd; i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        // create root node
        TreeNode root = new TreeNode(rootVal);

        // create left sub-tree
        root.left = helper(preorder,inorder, preBegin+1, preBegin+(index-inBegin)+1, inBegin, index);

        // create right sub-tree
        root.right = helper(preorder,inorder, preBegin+index-inBegin+1, preBegin-inBegin+inEnd, index+1,inEnd);

        return root;
    }
}
