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
        if (head == null || head.next == null) {
            return;
        }
        // 1. Find the mid element;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;


        // 2. Reverse the second half;

        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        // 3. Select one from left then right;
        fast = head;
        while (prev != null) {
            ListNode nextFast = fast.next;
            ListNode nextPrev = prev.next;

            fast.next = prev;
            prev.next = nextFast;

            fast = nextFast;
            prev = nextPrev;
        }
    }
}
