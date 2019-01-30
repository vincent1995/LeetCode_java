package bling.Leetcode;

import bling.Leetcode.util.ListNode;

public class leetcode_86 {
    public static void main(String[] args) {
        leetcode_86 sol = new leetcode_86();
        int[] nums = {1,4,3,2,5,2};
        int x = 3;
        ListNode head = util.createList(nums);
        ListNode ans = sol.partition(head,x);
        util.printList(ans);

    }
    public ListNode partition(ListNode head, int x) {

        ListNode lessList = null;
        ListNode greatList = null;
        ListNode lessCur = null;
        ListNode greatCur = null;
        ListNode cur =  head;
        while(cur != null){
            if(cur.val < x){
                if(lessList == null){
                    lessList = cur;
                    lessCur = cur;
                    cur = cur.next;
                    lessCur.next = null;
                }
                else{
                    lessCur.next = cur;
                    lessCur = lessCur.next;
                    cur = cur.next;
                    lessCur.next = null;
                }
            }else{
                if(greatList == null){
                    greatList = cur;
                    greatCur = cur;
                    cur = cur.next;
                    greatCur.next = null;
                }
                else{
                    greatCur.next = cur;
                    greatCur = greatCur.next;
                    cur = cur.next;
                    greatCur.next = null;
                }
            }
        }
        lessCur.next = greatList;
        return lessList;

    }
}
