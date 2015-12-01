package leetcode.prob234;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    
    public static void main (String [] args) {
        
        ListNode head = new ListNode (1);
        head.next = new ListNode (0);
        head.next.next = new ListNode (1);

        System.out.println(solution(head));
        
    }
    
    public static boolean solution(ListNode head) {
        
        if (head == null || head.next == null)
            return true;
        
        Stack<ListNode> stack = new Stack<ListNode> ();
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null) {
            stack.push(slow);
            if (fast.next == null) break;
            fast = fast.next.next;
            slow = slow.next;            
        }

        //fast = head;
        // Now just keep on popping the top the element from the 
        //for (ListNode node = stack.pop(); node != null; node = stack.pop()) {
        while (stack.isEmpty() == false){
            ListNode node = stack.pop();
            if (slow.val != node.val)
                return false;
            slow = slow.next;
        }
        
        return true;
    }
}