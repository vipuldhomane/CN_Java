package Module2.LInkedLists2.Assignment;

public class SwapTwoNodes {
    /*
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * Where 'n' is size of the Singly Linked List
     * 
     */

    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {

        if (i == j) {
            return head;
        }

        Node<Integer> currentNode = head, prev = null;
        Node<Integer> firstNode = null, secondNode = null, firstNodePrev = null, secondNodePrev = null;

        int pos = 0;

        while (currentNode != null) {

            if (pos == i) {
                firstNodePrev = prev;
                firstNode = currentNode;
            } else if (pos == j) {
                secondNodePrev = prev;
                secondNode = currentNode;
            }

            prev = currentNode;
            currentNode = currentNode.next;
            pos += 1;

        }

        if (firstNodePrev != null) {
            firstNodePrev.next = secondNode;
        } else {
            head = secondNode;
        }

        if (secondNodePrev != null) {
            secondNodePrev.next = firstNode;
        } else {
            head = firstNode;
        }

        Node<Integer> currentfirstNode = secondNode.next;
        secondNode.next = firstNode.next;
        firstNode.next = currentfirstNode;

        return head;
    }

}
