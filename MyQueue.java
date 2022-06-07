public class MyQueue<E> {
    private Object[] arr;
    private int head = 0;
    private int tail = -1;
    private int capacity;
    private int count = 0;

    public MyQueue(int size) {
        arr = new Object[size];
        capacity = size;
    }

    public void remove(int index) {
        if (count - index >= 0) {
            System.arraycopy(arr, index + 1, arr, index, count - index);
        }
        arr[count] = null;
        count--;
    }

    public void add(Object value) {
        tail = (tail + 1) % capacity;
        arr[tail] = value;
        count++;
    }

    public E peek() {
        if (count == 0) {
            return null;
        }
        System.out.println(arr[head].toString());
        return (E) arr[head];
    }

    public E poll() {
        if (count == 0) {
            return null;
        }
        E temp = (E) arr[head];
        System.out.println(temp.toString());
        head = (head + 1) % capacity;
        count--;
        return temp;
    }

    public int size() {
        return count;
    }

    public void clear() {
        arr = new Object[count];
    }
}