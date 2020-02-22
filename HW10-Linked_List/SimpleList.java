/**
 * @author Shreyas Casturi
 * An interface that contains methods to implement.
 * Correct implementations of these methods will produce a working Linked List.
 * DO NOT MODIFY THIS INTERFACE.
 * Good luck.
 **/
public interface SimpleList<T> {


    // takes an element of T type and an index, creates a Node filled with that element,
    // and adds it as the i-th node of the list.
    // EX: 0 -> 1 -> 2 -> 3, let's say I want to add element 4 at index 1.
    // Then: 0 -> 4 -> 1 -> 2 -> 3 is the correct list.
    // What changes will this cause?
    // Remember, throw exceptions when necessary.
    void addAtIndex(T data, int index); 


    // takes an index (throw exception if necessary), and retrieves the element
    // associated with the index-th node. ALSO: we swap the data of the (index-1)th
    // node with the data of the index-th node.
    // EX: 0 -> 1 -> 2 -> 3, list.get(2) will return "2",
    // and the final list will be: 0 -> 2 -> 1 -> 3.
    // What happens if we keep invoking get()
    // with smaller and smaller indices? Where will the data end up?   
    T get(int index); 

    // Check if a particular element is contained in a LinkedList.
    // This is an O(n) operation.
    boolean contains(T element); 

    // Tell us if the list is empty or not. A straightforward method.
    boolean isEmpty(); 


    // takes an index (check if index is valid), and retrieves and returns the data
    // at the index-th node, and removes the Node from the list. What changes will this cause?
    // EX: 0 -> 1 -> 2 -> 3 -> 4. list.removeAtIndex(2) will return "2". 
    // The linked list is then: 0 -> 1 -> 3 -> 4.
    // Throw exceptions when necessary.
    // THINK ABOUT WHAT VARIABLES MAY CHANGE AS A RESULT OF THIS REMOVE!!!
    T removeAtIndex(int index); 

    // A straightforward method.
    int size(); 

    // Take the current list, and transfer all of its data (not the Nodes themselves)
    // into an array of T type. Return this array. Make sure the array is allocated
    // only as much space as the list needs. That is, if there's seven elements in the list,
    // don't return a 10 element array with 7 filled spots and 3 non-filled spots.
    // Rather, return an array with 7 filled spots only.
    T[] toArray(); 
} 
