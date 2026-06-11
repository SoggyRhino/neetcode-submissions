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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        Queue<ListNode> queue = new ArrayDeque<>();

        int length = 0;
        while (head != null){
            queue.offer(head);
            if (queue.size() > n + 1){
                queue.poll();
            }
            head = head.next;
            length++;
        }


        if (length == n){
            result = result.next;
        } else {
            ListNode node = queue.poll();
            queue.poll();
            if (node != null)
                node.next = queue.poll();

        }
        return result;
    }
}
