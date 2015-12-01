package prob237;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Just replace the data of the next node with the data of the current n
 * node and detach the next node.
 * 
 * 
 */
public class Solution {
    public void deleteNode(ListNode node) {
    	
    	if (node == null || node.next == null) {
    		return;
    	}

    	ListNode next = node.next.next;
    	node.val = node.next.val;
    	node.next.next = null;
    	node.next = next;
    }
}