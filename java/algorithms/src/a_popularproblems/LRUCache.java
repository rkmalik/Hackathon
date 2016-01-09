package a_popularproblems;


import java.util.HashMap;

public class LRUCache {

	public class DoublyLinkedListPageNode {
		int val;
		int key;
		DoublyLinkedListPageNode next;
		DoublyLinkedListPageNode prev;

		public DoublyLinkedListPageNode(int key, int val) {
			this.key = key;
			this.val = val;
			this.next = null;
			this.prev = null;
		}

		public int getKey() {
			return key;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}
	}

	int capacity = 0;
    int len = 0;	
	HashMap<Integer, DoublyLinkedListPageNode> keys;

	DoublyLinkedListPageNode head = null;
	DoublyLinkedListPageNode tail = null;

	public LRUCache(int capacity) {
		System.out.println("Capacity " + capacity);
		this.capacity = capacity;
		keys = new HashMap<>();

	}

	public int get(int key) {

		if (keys.containsKey(key)) {

			DoublyLinkedListPageNode p = keys.get(key);
            removeNode (p);
            insertAtFront (p);
			System.out.println("Get key " + key + " Value " + p.val);
			return p.getVal();
		}

		return -1;
	}

	public void set(int key, int value) {

		DoublyLinkedListPageNode p = null;

		// If the key is already present update the key
		if (keys.containsKey(key)) {
			p = keys.get(key);
			p.setVal(value);
			removeNode (p);
		} else if (keys.size() == capacity) {

			p=tail;
			removeNode (tail);
			int k = p.getKey();
			keys.remove(k);
			p = new DoublyLinkedListPageNode(key, value);
			keys.put(key, p);
		} else {

			p = new DoublyLinkedListPageNode(key, value);
			if (head==null) {
				head=tail=p;
			}
			keys.put(key, p);
		}

		System.out.println("lrc.set Value " + key + " Value " + value);
		insertAtFront(p);

	}
	
	private void insertAtFront (DoublyLinkedListPageNode p) {
		
		if (head==null) {
			head=tail=p;
			return;
		}
		
		p.next=head;
		head.prev=p;
		head=head.prev;
		len++;
	}

	private void removeNode(DoublyLinkedListPageNode p) {

		// if p is null
		if (p == null)
			return;

		DoublyLinkedListPageNode tmp = p;
		
		// this is last node
		if (head == p) {

			if (head == tail) {
				head = tail = null;
				return;
			}

			head = head.next;
			head.prev = null;

		} else if (p == tail) {

			if (head == tail) {
				head = tail = null;
				return;
			}

			tail = tail.prev;
			tail.next = null;
			
		} else {
			
			p.prev.next = p.next;
			p.next.prev = p.prev;
			
		}

		p.prev = null;
		p.next = null;
		len--;
	}
	
	public static void main (String args[]) {
		LRUCache lrc =  new LRUCache (11);
		lrc.set(253,668);
		lrc.set(202,206);
		lrc.set(1231,3177);
		lrc.get(465);
		lrc.get(1333);
		lrc.set(651,3249);
		lrc.set(453,2472);
		lrc.get(1050);
		lrc.set(145,881);
		lrc.set(1256,1320);
		lrc.set(342,1528);
		lrc.get(37);
		lrc.set(280,2814);
		lrc.get(11);
		lrc.set(878,903);
		lrc.set(1278,2808);
		lrc.set(942,3238);
		lrc.set(397,57);
		lrc.set(89,305);
		lrc.set(998,1703);
		lrc.set(1386,1660);
		lrc.set(250,2904);
		lrc.get(865);
		lrc.set(21,639);
		lrc.set(1153,751);
		lrc.set(682,3156);
		lrc.set(1246,2932);
		lrc.set(1347,2057);
		lrc.set(955,1432);
		lrc.set(1092,3132);
		lrc.set(559,340);
		lrc.set(998,122);
		lrc.set(94,2562);
		lrc.set(194,1349);
		lrc.set(643,1808);
		lrc.set(905,2449);
		lrc.set(1361,607);
		lrc.set(1374,715);
		lrc.get(1052);
		lrc.get(535);
		lrc.get(1122);
		lrc.set(88,137);
		lrc.get(732);
		
	}
}