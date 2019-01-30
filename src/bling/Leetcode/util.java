package bling.Leetcode;

public class util {
    public static void println(Object o){
        System.out.println(o.toString());
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode createList(int[] nums){
        ListNode head = null;
        ListNode cur = null;
        for (int i = 0; i < nums.length; i++) {
            if(head == null){
                head = new ListNode(nums[i]);
                cur = head;
            }
            else{
                cur.next = new ListNode(nums[i]);
                cur = cur.next;
            }
        }
        return head;
    }
    public static void printList(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.print(Integer.toString(cur.val)+" -> ");
            cur = cur.next;
        }
        System.out.print("\n");
    }
}
