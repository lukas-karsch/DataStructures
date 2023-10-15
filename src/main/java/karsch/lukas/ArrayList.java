package karsch.lukas;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class ArrayList<T> {
    private Object[] arr;
    private int cursor = -1;
    private final int initialSize;

    public ArrayList() {
        initialSize = 16;
        arr = new Object[initialSize];
    }

    public ArrayList(int initialSize) {
        this.initialSize = initialSize;
        arr = new Object[initialSize];
    }

    public int size() {
        return cursor + 1;
    }

    public boolean isEmpty() {
        return cursor == -1;
    }

    public boolean contains(Object o) {
        for (int i = 0; i <= cursor; i++) {
            if (Objects.equals(arr[i], o)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(arr, cursor + 1);
    }


    public <E> E[] toArray(E[] baseArray) {
        return null;
    }


    public boolean add(T element) {
        cursor++;
        if (cursor >= arr.length) {
            doubleArraySize();
        }
        arr[cursor] = element;
        return true;
    }


    public boolean remove(Object o) {
        int indexOfObject = indexOf(o);
        if (indexOfObject == -1) {
            return false;
        }
        shiftLeft(indexOfObject, 1);
        cursor--;
        return true;
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
        this.arr = new Object[initialSize];
        cursor = -1;
    }


    public T get(int index) {
        return (T) arr[index];
    }


    public T set(int index, T element) {
        return null;
    }


    public void add(int index, T element) {

    }


    public T remove(int index) {
        T removed = (T) arr[index];
        shiftLeft(index, 1);
        cursor--;
        return removed;
    }


    public int indexOf(Object o) {
        for (int i = 0; i <= cursor; i++) {
            if (Objects.equals(arr[i], o)) {
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(Object o) {
        for (int i = cursor; i >= 0; i--) {
            if (Objects.equals(arr[i], o)) {
                return i;
            }
        }
        return -1;
    }


    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void shiftLeft(int index, int amount) {
        for (int i = index; i < arr.length; i++) {
            int position = i + amount;
            if (position > cursor) {
                arr[i] = null;
                continue;
            }
            final Object newValue = arr[position];
            arr[i] = newValue;
        }
    }

    private void shiftRight(int index, int amount) {

    }

    private void doubleArraySize() {
        this.arr = Arrays.copyOf(arr, Math.max(1, arr.length * 2));
    }
}
