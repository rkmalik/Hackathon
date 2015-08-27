package leetcode.prob2;

import java.util.ListIterator;
import java.util.Random;


public class Main {
	
	
	public static void main (String args[]) {
		
		ListNode head1 = new ListNode (9);
		ListNode tail1 = head1;
		Random randomGenerator = new Random();
		for (int i = 0; i < 1; i++) {
			int nodeData = randomGenerator.nextInt(9);
			ListNode node = new ListNode(nodeData);
			tail1.next = node;
			tail1 = node;
		}
		ListNode iterator = head1;
		
		System.out.println("\n\n**********List1************\n");
		
		// Print till all the element are printed
		while (iterator != null) {			
			System.out.println("List1 data : " + iterator.val);
			iterator = iterator.next;
		}
		
		
		ListNode head2 = new ListNode (0);
		/*ListNode tail2 = head2;
		for (int i = 0; i < 1; i++) {
			int nodeData = randomGenerator.nextInt(9);
			ListNode node = new ListNode(nodeData);
			tail2.next = node;
			tail2 = node;
		}*/
		iterator = head2;
		
		System.out.println("\n\n**********List2************\n");
		
		// Print till all the element are printed
		while (iterator != null) {			
			System.out.println("List2 data : " + iterator.val);
			iterator = iterator.next;
		}
		
		A2Add2Numbers obj = new A2Add2Numbers();
		
		ListNode newHead = obj.addTwoNumbers(head1, head2);
		
		System.out.println("\n\n**********New List************\n");
		
		iterator = newHead;
		
		// Print till all the element are printed
		while (iterator != null) {			
			System.out.println("Node data : " + iterator.val);
			iterator = iterator.next;
		}
	}

}
