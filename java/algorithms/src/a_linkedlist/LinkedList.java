package a_linkedlist;

public class LinkedList {

	private ListNode head;
	private ListNode tail;
	
	
	public class ListNode {
		
		private ListNode next;
		private int val;
		
		public ListNode (ListNode next, int val) {
			this.next = next;
			this.val = val;
		}
	}
	
	public ListNode insert (int val) {
		
		// There is not node in the list;
		if (head==null) {
			head = tail = new ListNode (null, val);
			return tail;
		}
		
		// there is already node in the list; 
		ListNode n = head;
		
		while (n.next!=null) {
			n=n.next;
		}
		
		n.next = new ListNode (null, val);
		tail=n.next;
		
		return tail;
	}
	
	public ListNode delete (int val) {
		
		if (head == null || head.next == null) return head;
		
		ListNode n = head; 
		ListNode prev = null;
		while (n!=null) {
			
			
			
			// Case 1: when the node is head
			
			if (n.val== val) {
				
				if (n==head) {
					
					if (head==tail) {
						head=tail = null;
					} else {
						head = head.next;
					}
					
				} else if (n==tail) {
					prev.next = null;
					tail = prev;
				} else {
					prev.next = n.next;
				}
				n.next = null;
				return n;
			} else {
				prev = n;
				n = n.next;
			}
		} 
		
		System.out.println ("No node with value = " + val + " found.");
		return null;
	} 
	
	
	public void reverse () {
		
		if (head == null || head.next== null) return;
		
		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode p3 = null;
		p1.next = null;
		tail = p1;
		
		while (p1!=null && p2!=null) {
			p3 = p2.next;
			p2.next = p1;
			p1=p2;
			p2 = p3;
		}
		
		head = p1; 
	}
	
	public ListNode getHead () {
		return head;
	}

	
	public static void main (String args []) {
		
		LinkedList list = new LinkedList ();
		
		
		for (int i = 1; i <= 10; i++) {
			list.insert(i);
		}
		
		ListNode p = list.getHead();
		while (p!= null) {
			System.out.print(p.val + "  ");
			p=p.next;
		}
		System.out.println("\n");
		list.reverse();
		
		p = list.getHead();
		while (p!= null) {
			System.out.print(p.val + "  ");
			p=p.next;
		}
		
		
		list.delete(11);
		list.delete(10);
		list.delete(1);
		list.delete(5);

		p = list.getHead();
		while (p!= null) {
			System.out.print(p.val + "  ");
			p=p.next;
		}
		
		
	}
}
