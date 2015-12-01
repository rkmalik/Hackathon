package prob2;


public class A2Add2Numbers {

	/**
	 * This method iterates through all the nodes of the two lists based on its
	 * place in the number. Digit's place is added to digits place, ten's place
	 * is added to tens place. Each addition generates a new node which is a part of the result
	 * 
	 * 
	 * 
	 * */
	public ListNode addTwoNumbers(ListNode list1, ListNode list2) {

		ListNode addedList = new ListNode(-1);
		ListNode iterator = addedList;
		
		int carry = 0;
		int remainder = 0;
		int sum = 0;

		do {

			sum = carry;
			
			if (list1 != null){
				sum += list1.val;
			}
			
			if (list2 != null){
				sum += list2.val;
			}

			remainder = sum % 10;
			carry = sum / 10;
			
			ListNode node = new ListNode(remainder);
			iterator.next = node;
			iterator = node;
			
			if (list1 != null) {
				list1 = list1.next;
			}
			
			if (list2 != null) {
				list2 = list2.next;
			}

		} while (list1 != null || list2 != null || carry != 0);
		
		// remove the dummy node from the list
		ListNode temp = addedList;
		addedList = addedList.next;
		temp.next = null;

		return addedList;
	}

	/**
	 * This code reverses the linklist.
	 * 
	 * @param list
	 *            the linklist which needs to be reversed
	 * @return ListNode returns the head of the reversed list
	 * */
	/*private ListNode reverseList(ListNode list) {

		ListNode head = list;
		ListNode prev = null;
		ListNode headNext = head.next;

		while (head.next != null) {
			head.next = prev;
			prev = head;
			head = headNext;
			headNext = headNext.next;
		}

		head.next = prev;
		list = head;

		return head;
	}*/
}
