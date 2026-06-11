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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        //slow is now in the middle of the array
        int n =0;
        while (fast != null && fast.next != null){
            n++;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = null;
        while (slow != null){
            n++;
            reverse = new ListNode(slow.val, reverse);
            slow = slow.next;
        }


        
        ListNode iter = head;
        int i =0;
        while (reverse != null){
            //instert
            iter.next = new ListNode(reverse.val, iter.next);
            reverse = reverse.next;
            
            i +=2;

            if (i < n){
                iter = iter.next;
                if (iter !=null)
                 iter = iter.next;
            } else {

                if (n % 2 == 0)
                    iter.next.next= null;
                else 
                    iter.next = null;

            }
        }

    }


    public static void print(ListNode head){
            List<Integer> list = new ArrayList<>();

            while (head != null){
                list.add(head.val);
                head = head.next;
            }

            System.out.println(list);
    }
}
