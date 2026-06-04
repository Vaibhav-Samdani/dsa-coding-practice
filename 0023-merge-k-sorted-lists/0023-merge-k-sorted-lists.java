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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = mergeSort(lists,0,lists.length-1);
        return ans;
    }

    ListNode mergeSort(ListNode[] nums, int start, int end) {
        if(nums.length <= 0) return null;
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;

        ListNode left = mergeSort(nums, start, mid);
        ListNode right = mergeSort(nums, mid + 1, end);

        return mergeTwoList(left, right);
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