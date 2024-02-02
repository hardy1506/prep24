

public class LinkedList {

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

/*    public LinkedList() {

    }*/

    // TODO :why do need to create ll with some value here in construction, can we not create empty ll ?
    //  since we are always checking all edge case like if length == 0 in each function do we even need this constructor ?

    public LinkedList(int value ) {
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

    public Node removeLast () {

        if ( length == 0 ) return null;

        Node temp = head;
        Node pre = head;

        while ( temp.next != null ) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next=null;

        length--;

        if ( length == 0 ) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend ( int value ) {

        // create new node
        Node newNode = new Node(value);

        // if ll is empty then head and tail points to new node
        // else, new node.next = head ( moved the pointer ) and then mark new node as head
        if ( length == 0 ) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next=head;
            head = newNode;
        }
        // increase length cz you added new item into the ll
        length++;

    }

    public Node removeFirst() {

        // case 1 : empty list
            if ( length == 0 ) return null;

        // case 2 : RTB case
                 /* EXA :

                   LL : v:p -> v:p -> v:p ... .. .
                   INPUT LL : 11:3 ->  3:23 -> 23:7 -> 7:null
                   OUTPUT LL : 3:23 -> 23:7 -> 7:null
                   method returns : 11:3
                  */


            // Create temp variable to point to head i.e 11:3
            Node temp = head;
            // move the head to next item i.e 3.23
            head = head.next;
            //remove temp varialbe
            temp.next=null;
            //reduce length by 1
            length--;

     //TODO : NOT A BIG FAN of doing this length==0 check 2x time, there has to be better way of handling both case1 and 3 in one shot
       // case 3 : Edge case, when LL has only one item i.e head and tail point to same element.

            if ( length == 0 ) {
                tail = null;
            }

        return temp;
    }

    public Node get (int index) {

        if ( index < 0 || index >= length) return null;
        //create tmp node, traverse until index and return tmp node
        Node temp = head;
        for ( int i=0;i<index;i++){
            temp=temp.next;
        }

        return temp;
    }

    public boolean set (int index, int value) {
        Node temp = get(index);
        if ( temp.next != null){
            temp.value=value;
            return true;
        }
        return false;
    }

    public boolean insert  (int index, int value) {

     // casees : cant add if index < 0 || index >= length
        // if index = 0, call prepend
        // if index = length, call append
        // meat
        // create new node, get (index -1)
        // move the pointers
        //

        if ( index < 0 || index >= length) return false;

        if ( index == 0){
            prepend(value);
            return true;
        }

        if ( index == length ){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next=temp.next;
        temp.next=newNode;

        length++;
        return true;
    }

    public Node remove (int index) {

        //TODO : cases  cant add if index < 0 || index >= length
        // if index ==0, call removeFirst () same return type
        // if index == length-1 remove last same return type
        // meat
        // Use 3 node varialbes, one pointing to index -1 ( call it prev, use get() ) and other on the index ( call it temp, temp=prev.next ) aka node to be removed.
        // prev.next = temp.next ( moved pointer to the skip node )
        // temp.next = null ( removed node by making pointer to null )
        // reduce length by 1

        if ( index < 0 || index >= length ) return null;
        if ( index == 0 ) removeFirst();
        if ( index == length) removeLast();

        Node prev = get(index-1); // this is big O(n)
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next=null;
        length--;


        return temp;

    }


    public void reverse () {

        //swap head and tail
       Node temp=head;
       head=tail;
       tail=temp;

       //
        Node after = temp.next;
        Node before=null;

        for(int i=0;i<length;i++){
            after = temp.next;
            temp.next=before;
            before=temp;
            temp=after;

        }

    }


    // LL problem :

    /**
     *
     LL: Find Middle Node ( ** Interview Question)
     Implement a method called findMiddleNode that returns the middle node of the linked list.
     If the list has an even number of nodes, the method should return the second middle node.

     * Solution  :

     Floyd's Tortoise and Hare algorithm, also known as the cycle detection algorithm or the "tortoise and hare" algorithm, is a popular algorithm used to detect cycles in a sequence of values or elements, particularly in linked lists. The algorithm is named after the idea of a tortoise (slow-moving) and a hare (fast-moving), reflecting the way two pointers traverse the sequence.
     Here's a basic outline of how the algorithm works:

     Initialization:

     Start with two pointers, one moving slow (tortoise) and the other moving fast (hare), both initially at the beginning of the sequence.
     Traverse the Sequence:

     Move the tortoise one step at a time.
     Move the hare two steps at a time.
     Cycle Detection:

     If there is no cycle, the hare will eventually reach the end of the sequence, and the algorithm terminates.
     If there is a cycle, the hare will eventually catch up to the tortoise within the cycle. Once the hare catches the tortoise, it's an indication that there is a cycle.
     Cycle Length Determination (Optional):

     After detecting a cycle, the algorithm can be extended to find the length of the cycle.
     This algorithm is efficient and has a time complexity of O(mu + lambda), where "mu" is the start of the cycle, and "lambda" is the length of the cycle. The algorithm is widely used in various applications, including cycle detection in linked lists and graph algorithms.
     *
     * NOTES :
     * When hear reaches the end, the tortoise is at the middle element.
     * we can add even/odd details by checking the length of LL and printing the correct item for covering fine-grained details or edge cases
     * you can always say print ( tortoise.next.value ) if list size is even and you want to print the outer
     * EXA :
     *  if the linked list is 1 -> 2 -> 3 -> 4 -> 5 -> 6, the two middle nodes are 3 and 4. The function will return the node containing the value 4.
     *
     *
     *
     * @return
     */
    public Node findMiddleNode () {

        Node tortoise=head;
        Node hare=head;

        while (hare != null && hare.next!=null) {
             // System.out.println("T : "+ tortoise.value);
             //System.out.println("H : "+ hare.value);
             //   System.out.println("-----");

            tortoise = tortoise.next; // move one step
            hare = hare.next.next; // move two steps

//TODO : solve more problems on cycle detection.
/*
            if (tortoise == hare) {
                System.out.println("Cycle detected!");
            }*/

        }

        return tortoise;

    }





}