package leetcode.prob61;

public class Main {
	
	
	public static void main (String args[]) {
		
		ListNode head = new ListNode(1);
		ListNode tail = head;
		tail.next = new ListNode(2);
		tail = tail.next;
        tail.next = new ListNode(3);
        tail = tail.next;       
        /*tail.next = new ListNode(4);
        tail = tail.next;		
        tail.next = new ListNode(5);
        tail = tail.next;*/
        
        
		Solution sol = new Solution();
		ListNode rethead = sol.rotateRight(head, 1);
		
		while (rethead != null) {
		    System.out.print(" " + rethead.val);
		    rethead = rethead.next;
		    
		}
		
		
	}

}
