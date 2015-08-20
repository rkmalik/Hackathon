package algorithms.ds.queue;

/**
 * Simple Node class holding the data and the reference to the next node.
 */
public class ListNode<E> {

    private E data;
    ListNode<E> next;

    public ListNode(
            E data) {
        this.data = data;
        this.next = null;
    }

    public void setData(
            E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }

    public void setNext(
            ListNode<E> next) {
        this.next = next;
    }

    public ListNode<E> getNext() {
        return this.next;
    }
}
