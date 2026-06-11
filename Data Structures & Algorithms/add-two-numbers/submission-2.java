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
       ListNode dummy = new ListNode(0, null);
        ListNode node = dummy;

        int carry = 0;
        while (l2 != null && l1 != null) {
            node.next = new ListNode(l1.val + l2.val + carry, null);
            node = node.next;

            carry = 0;
            if (node.val > 9) {
                carry = 1;
                node.val -= 10;
            }

            l2 = l2.next;
            l1 = l1.next;
        }

        
        
        while (l1 != null){
            node.next = new ListNode(l1.val + carry, null);
            node = node.next;

            carry = 0;
            if (node.val > 9) {
                carry = 1;
                node.val -= 10;
            }
            l1 = l1.next;
        }

        while (l2 != null){
            node.next = new ListNode(l2.val + carry, null);
            node = node.next;

            carry = 0;
            if (node.val > 9) {
                carry = 1;
                node.val -= 10;
            }
            l2 = l2.next;
        }

        if (carry > 0)
            node.next = new ListNode(1, null);

        return dummy.next;
    }
}
