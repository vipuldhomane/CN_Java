package Module2.LInkedLists2.Assignment;

public class FindNodeRec {
    public static int findNodeRec(Node<Integer> head, int n) {
        // Your code goes here
        if (head == null) {
            return -1;
        }
        if (head.data == n) {
            return 0;
        }
        int count = 1;
        int smallAns = findNodeRec(head.next, n);
        if (smallAns == -1) {
            return -1;
        } else {
            return count + smallAns;
        }

    }

    // using a helper function
    public static int findNodeRec(Node<Integer> head, int n, int position) {
        // Your code goes here
        if (head == null) {
            return -1;
        }
        if (head.data == n) {
            return position;
        }
        int smallAns = findNodeRec(head.next, n, position + 1);

        return smallAns;

    }

}
