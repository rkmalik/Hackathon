package algorithms.ds.stack;

public interface BaseStack<E> {

    public E push(
            E element);

    public E pop();

    public boolean isEmpty();

    public int size();

    public E peek();
}
