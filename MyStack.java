public class MyStack<E> {
    private int length = 0;
    private Node head = null;
    public class Node {

        private Object value;
        private Node nextNode;

        public Node(Object value){
            this.value = value;
        }

        public E getData() {
            return (E) value;
        }

        public void setData(Object value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    public int size(){
        return length;
    }

    public void push(Object value) {
        Node tempNode = new Node(value);
        tempNode.setNextNode(head);
        head = tempNode;
        length++;
    }

    public E pop() {
        Node node = head;
        head = head.getNextNode();
        length--;
        return node.getData();
    }

    public E peek() {
        return head.getData();
    }

    public void remove(int index) {
        if (index >= 0 && index < length) {
            MyStack.Node myStackCurrent = head;
            if (head != null) {
                for (int i = 0; i < index; i++) {
                    if (myStackCurrent.getNextNode() != null) {
                        myStackCurrent = myStackCurrent.getNextNode();
                    }
                }
            }
            myStackCurrent.setNextNode(myStackCurrent.getNextNode());
            length--;
        }
    }

    public void clear() {
        for (MyStack.Node x = head; x != null; ) {
            MyStack.Node next = x.nextNode;
            x.value = null;
            x.nextNode = null;
            x = next;
        }
        head = null;
        length = 0;
    }
}