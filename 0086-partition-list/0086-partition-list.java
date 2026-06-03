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
    public ListNode partition(ListNode head, int x) {
        ListNode P1 = new ListNode(-201);
        ListNode temp1 = P1;
        ListNode P2 = new ListNode(-201);
        ListNode temp2 = P2;

        ListNode temp = head;

        while(temp != null){
            if(temp.val < x){
                temp1.next = temp;
                temp1 = temp1.next;
            }else{
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        temp2.next = null;

        temp1.next = P2.next;

        return P1.next;


    }
}