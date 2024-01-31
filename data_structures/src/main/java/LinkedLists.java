

public class LinkedLists {

    class Node {
        int value;
        Node next;
        Node (int value) {
            this.value=value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedLists ( int value ) {
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }


    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append ( int value ) {

        Node newNode = new Node(value);
        // if LL is empty, then head and tail belongs to same node
        // else you append to tail
        if ( length == 0 ) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next=newNode;
            tail = newNode;
        }
        length++;
    }

}