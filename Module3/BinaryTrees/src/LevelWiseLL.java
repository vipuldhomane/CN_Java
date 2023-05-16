import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseLL {

    /*
     * Time complexity: O(N)
     * Space complexity: O(H)
     * 
     * where N is the number of nodes in the input BST
     * and H is the height of the input BST
     */
    // CN Solution
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
        pendingNodes.add(root);

        int currentLevelRemaining = 1;
        int nextLevelCount = 0;

        LinkedListNode<Integer> currentLevelHead = null;
        LinkedListNode<Integer> currentLevelTail = null;
        ArrayList<LinkedListNode<Integer>> output = new ArrayList<>();

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            currentNode = pendingNodes.remove();
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(currentNode.data);
            if (currentLevelHead == null) {
                currentLevelHead = newNode;
                currentLevelTail = newNode;
            } else {
                currentLevelTail.next = newNode;
                currentLevelTail = newNode;
            }
            if (currentNode.left != null) {
                pendingNodes.add(currentNode.left);
                nextLevelCount++;
            }
            if (currentNode.right != null) {
                pendingNodes.add(currentNode.right);
                nextLevelCount++;
            }
            currentLevelRemaining--;
            if (currentLevelRemaining == 0) {
                output.add(currentLevelHead);
                currentLevelHead = null;
                currentLevelTail = null;
                currentLevelRemaining = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return output;
    }

    // GPT solution
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel1(BinaryTreeNode<Integer> root) {
        // Write your code here
        ArrayList<LinkedListNode<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedListNode<Integer> dummy = new LinkedListNode<>();
            LinkedListNode<Integer> current = dummy;

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<Integer> node = queue.poll();
                current.next = new LinkedListNode<>(node.data);
                current = current.next;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(dummy.next);
        }

        return result;
    }

}
