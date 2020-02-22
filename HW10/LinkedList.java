import java.util.NoSuchElementException;
//I worked on the homework assignment alone, using only course materials.

/**
 * LinkedList class that implements SimpleList
 * @author Jade Law
 * @version 1.0
 * @param <T> is the type
 **/
public class LinkedList<T> implements SimpleList<T> {
    private Node<T> head;
    private int size;

    /**
     * Constructor for making a new linked list
     * Sets head to null and size of the linked list to 0
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * adds a Node to the linked list at the given index
     * @param data is the data to be added to the Node
     * @param index is the index where the Node will be inserted
     */
    public void addAtIndex(T data, int index) throws IllegalArgumentException {
        Node<T> n;
        Node<T> newNode;
        Node<T> prevNode;
        if (index > size || index < 0) { //for if cannot be added because of size constraint
            throw new IllegalArgumentException();
        } else if (index != 0 && index <= size) { //for if index is inside size but not the head or tail
            n = this.getNode(index);
            prevNode = this.getNode(index - 1);
            newNode = new Node<T>(data, n);
            prevNode.setNext(newNode);
            //System.out.println("1 add successful");
        } else if (index == 0) { // if inserting to beginning, changing head
            if (size >= 1) {
                n = head;
                newNode = new Node<T>(data, n);
                head = newNode;
            } else {
                newNode = new Node<T>(data, null);
                head = newNode;
            }
            //System.out.println("2 add successful");
            //System.out.println(head);
        } else if (index == size) { // if adding to end of list
            prevNode = this.getNode(index - 1);
            newNode = new Node<T>(data, null);
            prevNode.setNext(newNode);
            //System.out.println("3 add successful");
        }
        size += 1;
        //System.out.println("end add successful");
    }

    /**
     * gets the Node at the given index and swaps it with the node before it
     * @param index is the index that we want to retrieve the Node from
     * @return the data that is inside the Node at the index
     */
    public T get(int index) {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        } else {
            if (index == 0) {
                return head.getData();
            } else {
                Node<T> n = this.getNode(index);
                Node<T> prev = this.getNode(index - 1);
                if (index > 1) {
                    Node<T> prev2 = this.getNode(index - 2);
                    prev2.setNext(n);
                    prev.setNext(n.getNext());
                    n.setNext(prev);
                } else if (index == 1) {
                    prev.setNext(n.getNext());
                    n.setNext(prev);
                    head = n;
                }
                return this.getNode(index).getData();
            }
        }
    }

    /**
     * gets the Node at the given index
     * @param index is the index that we want to retrieve the Node from
     * @return the Node at the index
     */
    public Node<T> getNode(int index) throws NoSuchElementException, IllegalArgumentException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else if (index > size || index < 0) {
            throw new IllegalArgumentException();
        } else {
            Node<T> n = head;
            if (index == 0) {
                return n;
            }
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
            return n;
        }
    }

    /**
     * checks to see if the element is in the linked list
     * @param element is the element we are checking for
     * @return true if the linked list contains the element and false if not
     */
    public boolean contains(T element) {
        T data;
        Node<T> node;
        for (int i = 0; i < size; i++) {
            node = getNode(i);
            data = node.getData();
            if (data == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks to see if the linked list is empty
     * @return true if the linked list is empty and false if it isn't empty
     */
    public boolean isEmpty() {
        if (head == null && size == 0) {
            return true;
        }
        return false;
    }

    /**
     * removes the node at the given index from the linked list
     * @param index the index position to be removed from the linked list
     * @return the element that is removed from the linked list
     */
    public T removeAtIndex(int index) {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            T data = head.getData();
            head = this.getNode(1);
            size -= 1;
            return data;
        } else {
            Node<T> node = this.getNode(index);
            Node<T> prev = this.getNode(index - 1);
            prev.setNext(node.getNext());
            node.setNext(null);
            size -= 1;
            return node.getData();
        }
    }

    /**
     * gets the size of the linked list
     * @return the size of the linked list
     */
    public int size() {
        return size;
    }

    /**
     * turns the linked list into an array
     * @return the linked list as an array
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    Node<T> node = this.getNode(i);
                    arr[j] = node.getData();
                }
            }
        }
        return (T[]) arr;
    }
}