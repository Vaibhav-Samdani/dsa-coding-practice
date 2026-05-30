
import java.security.cert.LDAPCertStoreParameters;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 = reverse(l1);
        // l2 = reverse(l2);

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode newNode = new ListNode(-1);

        ListNode temp3 = newNode;

        int carry = 0;

        while (temp2 != null || temp1 != null) {
            int t1 = 0;
            int t2 = 0;
            if (temp1 != null) {
                t1 = temp1.val;
            }
            if (temp2 != null) {
                t2 = temp2.val;
            }

            int val = t1 + t2 + carry;
            carry = val / 10;
            val = val % 10;

            temp3.next = new ListNode(val);
            temp3 = temp3.next;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }

        if (carry > 0) {
            temp1 = newNode.next;

            while (temp1.next != null) {
                temp1 = temp1.next;
            }

            temp1.next = new ListNode(carry);
        }
        return newNode.next;
    }

    private ListNode reverse(ListNode temp) {
        ListNode prev = null;
        ListNode curr = temp;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}