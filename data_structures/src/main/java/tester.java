

public class tester {

    public static void appendTester (int size){

        LinkedLists ll = new LinkedLists(size);
        ll.makeEmpty();
        for(int i=1;i<10;i++){
            ll.append(i);
        }

        ll.getHead();
        ll.getTail();
        ll.getLength();

        System.out.println("\nLinked List:");
        ll.printList();

    }

    public static void main(String[] args) {
        appendTester(1);
    }
}
