package algorithms.ds.queue;

/**
 * Queue is a FIFO datastructure. This verison of datastructure supports following operations.
 * 
 * enQueue deQueue
 * 
 * 
 */
public interface BaseQueue<E> {

    public E deQueue();

    public BaseQueue<E> enQueue(
            E element);

    public boolean isEmpty();
    
    public int size();

    public E peek();
}
