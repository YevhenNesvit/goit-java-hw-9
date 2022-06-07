public class MyLinkedList<E>{
    private static int counter;
    private Node head;

    private static class Node {
        Node next;
        Object data;
        Node prev;

        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }
        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
    public void add(Object value) {

        if (head == null) {
            head = new Node(value);
        }

        Node myLinkedListTemp = new Node(value);
        Node myLinkedListCurrent = head;

        if (myLinkedListCurrent != null) {
            while (myLinkedListCurrent.getNext() != null) {
                myLinkedListCurrent = myLinkedListCurrent.getNext();
            }
            myLinkedListCurrent.setNext(myLinkedListTemp);
        }
        counter++;
    }

    public Object get(int index) {

        if (index < 0) {
            return null;
        }
        Node myLinkedListCurrent = null;
        if (head != null) {
            myLinkedListCurrent = head.getNext();
            for (int i = 0; i < index; i++) {
                if (myLinkedListCurrent.getNext() == null) {
                    return null;
                }
                myLinkedListCurrent = myLinkedListCurrent.getNext();
            }
            return myLinkedListCurrent.getData();
        }
        return myLinkedListCurrent;

    }

    public boolean remove(int index) {

        if (index < 0 || index > counter) {
            return false;
        }
        Node myLinkedListCurrent = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (myLinkedListCurrent.getNext() == null) {
                    return false;
                }
                myLinkedListCurrent = myLinkedListCurrent.getNext();
            }
            myLinkedListCurrent.setNext(myLinkedListCurrent.getNext().getNext());
            counter--;
            return true;
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public void clear() {
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = null;
        counter = 0;
    }
}