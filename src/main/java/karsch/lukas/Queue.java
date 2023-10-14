package karsch.lukas;

public class Queue<T> {
    private Node<T> head = null; //return this
    private Node<T> tail = null; //add to this

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public T poll() {
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }
}

