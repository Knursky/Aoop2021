package wsb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Container<E> implements Collection<E> {
    private ArrayList<E> list;
    private int counter;

    public Container() {
        list = new ArrayList<>();
    }

    public int getCounter() {
        return counter;
    }

    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(E e) {
        counter++;
        return list.add(e);
    }

    @Override
    public boolean remove(Object o) {
        counter++;
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        counter++;
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        counter++;
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        counter++;
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        counter++;
        list.clear();
    }
}