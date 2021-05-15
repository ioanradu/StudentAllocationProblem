package linkedListReview;

public class MyLinkedList {
    Node start, prev;

    public int getSize() {
        int size = 0;
        Node n = start;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (start == null) {
            start = newNode;
        } else {
            Node n = start;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }
    }

    public void show() {
        Node n = start;
        while (n != null) {
            System.out.print(n.info + " ");

            n = n.next;
        }
        System.out.println();
    }

    public int getAt(int index) {
        int nrOfNodes = 0;
        Node n = start;
        while (n != null && nrOfNodes < index) {
            n = n.next;
            nrOfNodes++;
        }
        return n.info;
    }

    public void showIO(Node n) {
        if (n == null) {
            return;
        } else {
            System.out.print(n.info + " ");
            showIO(n.next);
        }
    }

    public void reverseIO(Node n) {
        if (n == null) {
            return;
        } else {
            reverseIO(n.next);
            System.out.print(n.info + " ");
        }
    }
}


