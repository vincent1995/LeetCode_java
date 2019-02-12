package bling.Leetcode;

import bling.Leetcode.util.TreeNode;

public class leetcode_112 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;
        leetcode_112 sol = new leetcode_112();
        util.println(sol.hasPathSum(n1,1));
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return helper(root,0,sum);
    }
    boolean helper(TreeNode node, int cur, int target){
        if(node.left == null && node.right == null)
            return cur+node.val == target;

        if(node.left!=null && helper(node.left,cur+node.val,target))
            return true;
        if(node.right!=null && helper(node.right,cur+node.val,target))
            return true;
        return false;
    }
}
