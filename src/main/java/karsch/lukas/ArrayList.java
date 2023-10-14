package karsch.lukas;

import java.util.*;

public class ArrayList<T> {
    private Object[] arr;
    private int cursor = -1;
    
    public ArrayList() {
        arr = new                 Object[16];
    }
    
    public ArrayList(int initialSize) {
        arr = new Object[initialSize];
    }
    
    public int size() {
        return cursor + 1;
    }

    public boolean isEmpty() {
        return cursor == -1;
    }
    
    public boolean contains(Object o) {
        for(int i = 0; i < cursor; i++) {

        }
        return false;
    }
    
    public Object[] toArray() {
        return new Object[0];
    }

    
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    
    public boolean add(T t) {
        return false;
    }

    
    public boolean remove(Object o) {
        return false;
    }

    
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    
    public void clear() {

    }

    
    public T get(int index) {
        return null;
    }

    
    public T set(int index, T element) {
        return null;
    }

    
    public void add(int index, T element) {

    }

    
    public T remove(int index) {
        return null;
    }

    
    public int indexOf(Object o) {
        return 0;
    }

    
    public int lastIndexOf(Object o) {
        return 0;
    }

    
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
