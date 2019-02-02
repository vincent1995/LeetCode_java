package bling.Leetcode;

import bling.Leetcode.util.TreeNode;

import java.util.Stack;

public class leetcode_99 {
    public static void main(String[] args) {
        leetcode_99 sol = new leetcode_99();

        TreeNode tree = sol.makeTree();
        sol.recoverTree(tree);
    }
    TreeNode makeTree(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n2.right = n3;
        return n1;
    }
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        boolean waitForFirstElement = true;
        int lastVal = 0;
        TreeNode lastNode = null;
        TreeNode largerNode = null;
        TreeNode smallerNode = null;

        // non-recursive in-order traversal
        while(cur!=null || stack.size() > 0){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;

            if(waitForFirstElement){
                lastVal = val;
                lastNode = cur;
                waitForFirstElement = false;
            }
            else{
                if(val < lastVal){
                    if(largerNode == null){
                        largerNode = lastNode;
                    }
                    smallerNode = cur;
                }
                lastVal = val;
                lastNode = cur;
            }
            cur = cur.right;
        }
        // swap largerNode and smallerNode
        int temp = largerNode.val;
        largerNode.val = smallerNode.val;
        smallerNode.val = temp;
    }
}
