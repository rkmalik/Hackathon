package leetcode.prob203;
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = head;
        
        while (node!= null) {
            
            if (node.val == val) {
                
                if (node == head) {
                    node = node.next;
                    head.next = null;
                    head = node;
                } else {
                    prev.next = node.next;
                    ListNode temp = node;
                    node = node.next;
                    temp.next = null;                 
                } 
                
            } else {
                prev = node;
                node = node.next;
            }
        }
        
        return head;
    }
}