package algorithms.ds.queue;

import org.apache.commons.lang3.Validate;

/**
 * This class provides all the queue related features for the algorithms code. This implementation is based on
 * ArrayList.
 * 
 */
public class QueueArrayBased<E> implements BaseQueue<E> {

    E[] items;
    int head;
    int tail;
    int size;

    public QueueArrayBased(
            int size) {
        items = (E[]) new Object[size];
        this.size = 0;
    }
    
    public int size() {
        return size;
    }

    /**
     * Deletes the items from the queue.
     * 
     */
    public E deQueue() {

        // Condition checks if this can be underflow
        if (size == 0)
            return null;

        /**
         * Check if currently the head is at the last position, if it is at the last position then return the first
         * element.
         */
        if (head + 1 == size) {
            head = 0;
        } else {
            ++head;
        }

        size--;

        E item = items[head];
        items[head] = null;

        return item;
    }

    /**
     * This method will insert the elements to the end of the array.
     */
    public QueueArrayBased<E> enQueue(
            E element) {

        Validate.notNull(element, "Element to enqueue can not be empty.", element);

        /**
         * Check if this insert will overflow the queue.
         */
        if (size == items.length) {
            return null;
        }

        /**
         * Insert the element at the proper position in the array
         */
        if (tail + 1 == items.length) {
            tail = 0;
        } else {
            tail++;
        }

        items[tail] = element;

        size++;

        return this;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public String toString() {
        
        String queueInfo = "Queue : \n";
        queueInfo = String.format("%s \n", queueInfo);
        
        for (int i = 0; i < items.length; i++) {
            
            queueInfo = String.format("%s||%s||->", queueInfo, items[i]);
            
        }
        
        return queueInfo;
        
    }
    
    public E peek() {

        if (head == -1)
            return null;

        return items[head];
    }
}
