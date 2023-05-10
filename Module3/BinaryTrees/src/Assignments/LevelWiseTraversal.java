import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseTraversal {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        // Your code goes here

        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
        nodesToPrint.add(root);
        nodesToPrint.add(null);
        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();
            if (front == null) {
                if (nodesToPrint.isEmpty())
                    break;
                else {
                    System.out.println();
                    nodesToPrint.add(null);
                }

            } else {
                System.out.print(front.data + " ");
                if (front.left != null)
                    nodesToPrint.add(front.left);
                if (front.right != null)
                    nodesToPrint.add(front.right);
            }
        }
    }
}
