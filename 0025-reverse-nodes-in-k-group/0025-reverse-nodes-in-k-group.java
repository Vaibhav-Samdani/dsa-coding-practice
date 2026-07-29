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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevG = dummy;
        ListNode curr = head;
        ListNode groupHead = curr;
        ListNode nextG = null;
        ListNode prev = null;

        while (curr != null) {
            ListNode kth = nextGroup(curr, k);
            if (kth == null) break;
            nextG = kth.next;
            prev = nextG;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            prevG.next = prev;
            groupHead.next = curr;
            prevG = groupHead;
            groupHead = curr;
        }

        return dummy.next;
    }

    ListNode nextGroup(ListNode node, int k) {
        for (int i = 1; i < k; i++) {
            if (node == null) return null;
            node = node.next;
        }

        return node;
    }
}
