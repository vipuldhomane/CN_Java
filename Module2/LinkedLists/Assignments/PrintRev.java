package Module2.LinkedLists.Assignments;

public class PrintRev {
    public static void printReverse(Node<Integer> root) {
        if (root == null) {
            return;
        }

        printReverse(root.next);
        System.out.print(root.data + " ");

    }

}
