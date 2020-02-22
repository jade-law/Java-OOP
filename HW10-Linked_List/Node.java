/**
 * @author Carl Schriever
 * The Node class to use for your linked list
 * DO NOT MODIFY
 **/
class Node<T> {

    private T data;
    private Node<T> next;
    
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    // get the data of the current node.
    public T getData() {
        return data;
    }

    // get the current Node's next Node. THIS DOES NOT RETURN DATA.
    public Node<T> getNext() {
        return next;
    }

    // changes the data of the current node.
    public void setData(T data) {
        this.data = data;
    }

    // changes what the current node's next Node is.
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
