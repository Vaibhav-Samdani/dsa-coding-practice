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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoList(left,right);
    }

    ListNode getMid(ListNode node){
        if(node == null && node.next == null) return node;
        ListNode slow = node;
        ListNode fast = node;


        while(fast.next != null && fast.next.next != null){ 
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midPrev = slow;
        ListNode mid = slow.next;

        midPrev.next = null;

        return mid;

    }

    ListNode mergeTwoList(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(left != null && right != null){
            if(left.val <= right.val){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        if(left != null){
            temp.next = left;
        }
        if(right != null){
            temp.next = right;
        }

        return dummy.next;
    }
}