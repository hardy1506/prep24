

public class tester {

    public static void appendTester (int value){

        LinkedList ll = new LinkedList(value);
        ll.makeEmpty();
        for(int i=2;i<10;i++){
            ll.append(i);
        }

        ll.getHead();
        ll.getTail();
        ll.getLength();

        System.out.println("\nLinked List:");
        ll.printList();

    }

    public static void removeLastTester (int value){

        LinkedList ll = new LinkedList(value);
        ll.makeEmpty();
        for(int i=1;i<10;i++){
            ll.append(i);
        }
        ll.printList();
        ll.removeLast();
        System.out.println("------------------");
        ll.printList();
    }

    public static void ll_ops_tester (int value) {

        //create ll and add to elements into it
        LinkedList ll = new LinkedList(value);
       // ll.makeEmpty();
        for(int i=2;i<10;i++){
            ll.append(i);
        }
       // System.out.println("------  Before ------");
       // ll.printList();
        //remove last 2
        ll.removeLast();
        ll.removeLast();

        //prepend node with value 100
        ll.prepend(100);

        //remove the node added above
        ll.removeFirst();

        // print ll
       // System.out.println("------  After -----");
       // ll.printList();
        //get
        System.out.println("------  After get -----");

        System.out.println(ll.get(2).next.value); // this one can help remove a lot of extra variables which we use for traverse etc
        System.out.println(ll.get(2).value);
        System.out.println("------  After set -----");

        //set
        ll.set(2,2000);
        System.out.println(ll.get(2).value);

        // insert
        ll.insert(2,1000);
        System.out.println(ll.get(2).value);
        System.out.println(ll.get(3).value);

        //remove
        System.out.println("----------");
        ll.remove(2);
        System.out.println(ll.get(2).value);



    }

    public static void reverse_tester(int value){

        LinkedList ll = new LinkedList(value);
        // ll.makeEmpty();
        for(int i=2;i<6;i++){
            ll.append(i);
        }
        ll.printList();
        ll.reverse();
        System.out.println("----------");
        ll.printList();

    }
    public static void main(String[] args) {

        //appendTester(1);
       // removeLastTester(1);
       // ll_ops_tester(1000);
        reverse_tester(1);

    }
}
