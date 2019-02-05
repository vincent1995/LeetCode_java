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
        helper(preorder,inorder,0,n,0,n,root);
        return root;
    }

    void helper(int[] preorder, int[] inorder,int preBegin, int preEnd, int inBegin, int inEnd, TreeNode root){

        if(preBegin>=preEnd)
            return;

        int rootVal = preorder[preBegin];

        int inorderRootIndex = Arrays.asList(inorder).indexOf(rootVal);
        int leftTreeSize = inorderRootIndex - inBegin;
        int rightTreeSize = inEnd - inorderRootIndex-1;

        // create root node
        root = new TreeNode(rootVal);

        // create left sub-tree
        int leftTreePreBegin = preBegin+1;
        int leftTreePreEnd = leftTreePreBegin+leftTreeSize;
        int leftTreeInBegin = inBegin;
        int leftTreeInEnd = inorderRootIndex;
        helper(preorder,inorder,leftTreePreBegin,leftTreePreEnd,leftTreeInBegin,leftTreeInEnd,root.left);

        // create right sub-tree
        int rightTreePreBegin = leftTreePreEnd;
        int rightTreePreEnd = preEnd;
        int rightTreeInBegin = inorderRootIndex + 1;
        int rightTreeInEnd = inEnd;
        helper(preorder,inorder,rightTreePreBegin,rightTreePreEnd,rightTreeInBegin,rightTreeInEnd,root.right);
    }
}
