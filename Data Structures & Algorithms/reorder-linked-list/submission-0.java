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
        
        ListNode reverse = null;
        ListNode iter = head;

        int n =0;
        while(iter != null){
            n++;
            reverse = new ListNode(iter.val, reverse);
            iter = iter.next;

        }

        print(head);
        print(reverse);

        iter = head;
        
        int i =0;
        while (i < n){

            // insert nth - j
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

        iter = null;

        print(head);
        print(reverse);
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
