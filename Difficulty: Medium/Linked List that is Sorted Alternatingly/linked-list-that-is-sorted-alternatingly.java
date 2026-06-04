/*
class Node {
	int data;
	Node next;
	
	public Node (int data) {
		this.data = data;
		this.next = null;
	}
}
*/

class Solution {
	public Node sort(Node head) {
		if (head == null || head.next == null)
			return head;
		
		Node curr = head;
		Node next = head.next;
		
		Node nextHead = next;
		
		while (next != null && next.next != null) {
			curr.next = next.next;
			curr = curr.next;
				next.next = curr.next;
				next = next.next;
			
		}
		
		curr.next = null;
		
		if (next != null) {
			next.next = null;
		}
		
		Node tail = head;
		
		while (tail.next != null) {
			tail = tail.next;
		}
		
		tail.next = reverseList(nextHead);
		
		return head;
		
	}
	
	public Node reverseList(Node head) {
		Node curr = head;
		Node prev = null;
		
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
}
