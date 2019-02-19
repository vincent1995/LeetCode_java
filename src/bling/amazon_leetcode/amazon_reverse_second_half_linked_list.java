package bling.amazon_leetcode;
import bling.Leetcode.util;
import bling.Leetcode.util.ListNode;

public class amazon_reverse_second_half_linked_list {
    public static void main(String[] args) {
        amazon_reverse_second_half_linked_list sol = new amazon_reverse_second_half_linked_list();
        ListNode head = util.createList(new int[]{1,2,3,4,5,6,7,8});
        ListNode ans = sol.reverse(head);
        util.printList(ans);
    }
    ListNode reverse(ListNode head){
        ListNode dumbNode = new ListNode(1);
        dumbNode.next = head;
        ListNode slow = dumbNode;
        ListNode fast = dumbNode;

        // go to position
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // do reverse
        ListNode prev = null;
        ListNode cur = slow.next;
        ListNode next = null;
        while(cur != null){
            // set new pointer
            next = cur.next;
            cur.next = prev;

            // move
            prev = cur;
            cur = next;
        }
        slow.next = fast;
        return head;
    }
}
