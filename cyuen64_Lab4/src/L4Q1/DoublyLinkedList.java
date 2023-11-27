package L4Q1;

import java.util.ArrayList;

public class DoublyLinkedList <E> {
    public static class Node<E> {//create a nested class Node<E>

        //declare variables
        private E element;
        private Node<E> prev;
        private Node<E> next;

        //create constructor
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        //getters
        public E getElement() {
            return element;
        }
        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }

        //setters
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }//end of nested code

    //declare variables
    private Node<E> trailer;
    private int size = 0;
    private Node<E> header;

    //create instance variables
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    //returns number of elements in linked list
    public int size() {
        return size;
    }

    //test if linked list is empty
    public Boolean isEmpty() {
        return size == 0;
    }

   //place just before the trailer
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    //method to add an element in between nodes
    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    //return node containing element (null if empty)
    public Node<E> findNode(E e) {
        if (isEmpty()) {
            return null; // return null if the list is empty
        }

        Node<E> current = header.getNext(); //start from the first element after the header
        while (current != trailer) {
            if (current.getElement().equals(e)) {
                return current; //return the node if element e is found
            }
            current = current.getNext();
        }

        return null; // element e not found in the list
    }

    //toString method to provide string representation of list
    @Override
    public String toString() {
        ArrayList<E> arrayList = new ArrayList<>();
        Node<E> current = header.getNext(); //start from the first element after the header

        while (current != trailer) {
            arrayList.add(current.getElement());
            current = current.getNext();
        }
        return arrayList.toString();
    }
}

