public class MyArrayList <T>{
    private final int SIZE = 10;
    private Object[] array = new Object[SIZE];
    private int position = 0;

    public void add(Object value) {
        if(position == array.length-1)
            increase(array.length * 3 / 2 + 1);
        array[position++] = value;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        if (position - index >= 0) {
            System.arraycopy(array, index + 1, array, index, position - index);
        }
        array[position] = null;
        position--;
    }

    public int size() {
        return position;
    }

    public void clear() {
        array = new Object[SIZE];
    }

    /*Метод для увеличения массива.*/
    private void increase(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, position);
        array = newArray;
    }
}
