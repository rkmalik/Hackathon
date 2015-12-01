package algorithms.ds.stack;

public class StackArrayBased<E> implements BaseStack<E> {

    int size;
    E[] items;
    int top;

    public StackArrayBased(
            int size) {
        items = (E[]) new Object[size];
        this.size = 0;
        this.top = -1;
    }

    public E push(
            E element) {

        /**
         * Check for the overflow condition. if the array is already full. if the array is already full then there is no
         * need to push the data.
         */
        if (size == items.length)
            return null;

        items[++top] = element;

        return items[top];
    }

    public E pop() {

        /**
         * Check for the underflow of the stack.
         */
        if (size == 0) {
            return null;
        }

        E data = items[top];
        items[top--] = null;

        return data;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int size() {
        return size;
    }

    public E peek() {

        if (top == -1)
            return null;

        return items[top];
    }

}
