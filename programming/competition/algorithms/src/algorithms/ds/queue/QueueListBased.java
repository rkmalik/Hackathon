package algorithms.ds.queue;

public class QueueListBased<E> implements BaseQueue<E> {

    int size;

    ListNode<E> head, tail;

    public QueueListBased() {
        size = 0;
        head = null;
        tail = null;
    }
    
    public int getSize() {
        return size;
    }

    /**
     * This method deletes the node from the queue and returns the data of the deleted item.
     */
    public E deQueue() {

        /**
         * If the head is null, then there is no element in the queue.
         * This case will return null to the client
         */
        if (head == null)
            return null;

        ListNode<E> front = head;
        head = head.next;
        front.next = null;

        size--;

        if (size == 0) {
            tail = head = null;
        }

        return front.getData();
    }

    public QueueListBased<E> enQueue(
            E element) {

        /**
         * This creates a new node with the element.
         */
        ListNode<E> node = new ListNode<E>(element);

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }

        size++;
        
        return this;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public E getFirst() {
        return head.getData();
    }
    
    public String toString () {
        
        String queueInfo = "Queue : \n";
        queueInfo = String.format("%s \n", queueInfo);
        
        
        for (ListNode<E> node = head; node != null; node = node.next) {
            queueInfo = String.format("%s||%s||->", queueInfo, node.getData());
        }
        return queueInfo;
    }
}
