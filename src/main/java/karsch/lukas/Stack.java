package karsch.lukas;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] arr;
    private int cursor = -1;

    public Stack() {
        this.arr = new Object[16];
    }

    public Stack(int initialSize) {
        this.arr = new Object[initialSize];
    }

    public void push(T element) {
        cursor++;
        if(cursor == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[cursor] = element;
    }

    public T pop() {
        if(cursor == -1) {
            throw new EmptyStackException();
        }
        cursor--;
        return (T) arr[cursor + 1];
    }

    public T peek() {
        if(cursor == -1) {
            throw new EmptyStackException();
        }
        return (T) arr[cursor];
    }

    public int size() {
        return cursor + 1;
    }
}
