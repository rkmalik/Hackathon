package leetcode.prob146;

import java.util.HashMap;

public class LRUCache {

	private HashMap<Integer, DListNode> map;
	private LRUList lruList;
	private int capacity;

	public class DListNode {
		int val;
		int key;
		DListNode prev;
		DListNode next;

		public DListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
		
	}

	public class LRUList {

		DListNode head;
		DListNode tail;
		int size;

		public void enQueue(DListNode node) {

			size++;
			
			if (head == null) {
				tail = head = node;
				return;
			}

			node.next = head;
			head.prev = node;
			head = node;
		}
		
		/**
		 * This method remove the item from the list, it can be any item, 
		 * weather from the begining or from the end. 
		 * 
		 * */
		
		public void moveToFront (DListNode node) {
			
			/**
			 * There can be 3 scenarios
			 * 
			 * 1. if this is the head node already
			 * 2. if this is the tail node.
			 * 
			 * 3. If this is some node in between. 
			 * 
			 * */
			
			if (node == head || node == null) return;
			
			/**
			 * Case 2: check if this is a tail node. 
			 * 
			 * 
			 * */ 

			node.prev.next = node.next;
			
			if (node.next != null) {
				node.next.prev = node.prev;
			} else {
				tail = node.prev;
			}
			
			node.next = head;
			node.prev = null;
			head.prev = node;
			head = node;
		}

		/**
		 * This deletes the node from the end of the list
		 */
		public DListNode deQueue() {

			if (tail == null) {
				return null;
			}

			DListNode node = tail;

			/**
			 * means there is only one node in the list so after deletion it
			 * will be the last node.
			 */
			if (tail == head) {
				tail = head = null;
				
				/**
				 * This is the case when there are more than one element in the
				 * Cache.
				 * */
			} else {
				tail = tail.prev;
				tail.next = null;
			}

			size--;
			return node;
		}

	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, DListNode>();
		lruList = new LRUList();
	}

	public int get(int key) {

		DListNode node = map.get(key);

		if (node == null) {
			return -1;
		}
		
		lruList.moveToFront(node);
		
		return node.val;
	}

	public void set(int key, int value) {

		DListNode node = map.get(key);

		/**
		 * Case 1 : check if the node is already present in the list or not
		 */
		if (node != null) {
			node.val = value;
			lruList.moveToFront(node);
			return;
		}

		/**
		 * Case 2: If node is not present then the we first need to check if the
		 * capacity is exhausted or not. If capacity is not exhausted then
		 * insert the item in the queue and keep
		 * 
		 * keep a reference of the node in the hash table for O(1) retrieval
		 * 
		 */
		DListNode newNode = new DListNode(key, value);

		if (lruList.size == capacity) {
			node = lruList.deQueue();
			map.remove(node.key);
		}
		lruList.enQueue(newNode);
		map.put(key, newNode);
	}
}