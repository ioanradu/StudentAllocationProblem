package linkedListReview;

public class Main {
    public static void main(String[] args) {

        MyLinkedList ml = new MyLinkedList();

        ml.add(2);
        ml.add(5);
        ml.add(6);
        ml.add(7);
        ml.add(8);
        ml.add(6);
        ml.add(6);
        ml.add(6);
        System.out.println(ml.getSize());
        ml.show();
        ml.show();
        ml.show();
        ml.show();

        System.out.println(ml.getAt(4) + " ");

        ml.showIO(ml.start);
        System.out.println();
        ml.reverseIO(ml.start);
    }
}
