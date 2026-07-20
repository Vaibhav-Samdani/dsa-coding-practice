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
        ListNode temp = head;
        int k = 0;

        while (temp != null) {
            k++;
            temp = temp.next;
        }

        if(k == n){
            head = head.next;
            return head;
        }

        temp = head;

        for (int i = 0; i < k - n - 1; i++) {
            temp = temp.next;
        }
        
        temp.next = temp == null || temp.next == null ? null : temp.next.next;

        return head;
    }
}
