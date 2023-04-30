package Module2.LInkedLists2.Assignment;

public class DeleteMafterN {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * Where 'n' is size of the Singly Linked List
     */

    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {

        if (M == 0 || head == null) {
            return null;
        }

        if (N == 0) {
            return head;
        }

        Node<Integer> currentNode = head;
        Node<Integer> temp = null;

        while (currentNode != null) {
            int take = 0;
            int skip = 0;

            while (currentNode != null && take < M) {

                if (temp == null) {
                    temp = currentNode;
                } else {
                    temp.next = currentNode;
                    temp = currentNode;
                }

                currentNode = currentNode.next;
                take += 1;
            }

            while (currentNode != null && skip < N) {
                currentNode = currentNode.next;
                skip += 1;
            }
        }

        if (temp != null) {
            temp.next = null;
        }

        return head;
    }
}
