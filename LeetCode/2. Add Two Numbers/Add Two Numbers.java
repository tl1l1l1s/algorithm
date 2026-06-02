/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(-1);
        ListNode current = new ListNode(-1);

        boolean next = false;
        while(l1 != null || l2 != null) {
            int curVal = 0;  

            if(l1 == null) {
                curVal = l2.val;
            } else if(l2 == null) {
                curVal = l1.val;
            } else {
                curVal = l1.val + l2.val;
            }

            if(next) {
                curVal += 1;
            }
            next = false;

            if(curVal >= 10) {
                next = true;
                curVal -= 10;
            }
            
            ListNode temp = new ListNode(curVal);
            if(l1 != null) {
               l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;            
            }
            
            if(answer.val == -1) {
                answer = temp;
                current = answer;
            } else {
                current.next = temp;
            }

            current = temp;
        }

        if(next) {
            ListNode temp = new ListNode(1);
            current.next = temp;
        }

        return answer;
    }
}