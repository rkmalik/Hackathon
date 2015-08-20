package algorithms.ds.stack;

import algorithms.common.ListNode;

public class StackListBased<E> implements BaseStack<E> {

    int size;

    ListNode<E> top;

    public StackListBased() {
        size = 0;
        top = null;
    }

    public E push(
            E element) {

        ListNode<E> node = new ListNode<E>(element);

        /**
         * Check if this is the first element to insert in the stack.
         */
        if (top == null) {
            top = node;
            return top.getData();
        }

        node.setNext(top);
        top = node;
        size++;
        return top.getData();
    }

    public E pop() {

        if (top == null)
            return null;

        /**
         * get the top element of the stack
         */
        ListNode<E> node = top;
        top = top.getNext();
        node.setNext(null);
        size--;

        return node.getData();
    }

    public boolean isEmpty() {

        return size == 0 ? true : false;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (top == null)
            return null;

        return top.getData();
    }

    public String toString() {

        String stackinfo = "Stack : \n";
        stackinfo = String.format("%s \n", stackinfo);

        for (ListNode<E> node = top; node != null; node = node.getNext()) {
            stackinfo = String.format("%s||%s||->", stackinfo, node.getData());
        }
        return stackinfo;
    }
}
