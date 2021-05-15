package allocation;

public class Main {
    static Node head;
    public static void main(String[] args) {
        Node node1 = new Node("nod1");
        Node node2 = new Node("nod2");
        Node node3 = new Node("nod3");
        Node node4 = new Node("nod4");
        Node node5 = new Node("nod5");

        head = node1;
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        //show();
        System.out.println();
        System.out.println();

        insertAt(node1, node5, 1);

        // parcurgere dupa inserare node5
        show();

        //reverseOrder(node1, node5);
    }

    public static void show(){
        while (head != null){
            System.out.println(head.getInfo());
            head = head.getNext();
        }
    }
    public static void insertAt(Node head, Node toBeInserted, int index) {
        int nrOfNodes = 0;
        while (head != null) {
            if (nrOfNodes == index - 1) {
                toBeInserted.setNext(head.getNext());
                head.setNext(toBeInserted);
            }
            head = head.getNext();
            nrOfNodes++;
        }
    }

   /* public static Node reverseOrder(Node x, Node y){
        if(y == null) {
            return x;
        }
            Node y1 = y;
            y.setNext(y);
            y1.setNext(x);
        return reverseOrder(y1,y);
    }*/
}