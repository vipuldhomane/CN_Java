public class ReplaceWithSumGreater {

    /*
     * Binary Tree Node class
     *
     * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
     * right;
     *
     * public BinaryTreeNode(T data) { this.data = data; } }
     */
    /*
     * Time complexity: O(N) Space complexity: O(H)
     *
     * where N is the number of nodes in the input BST and H is the height of the
     * input BST
     */

    public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum) {
        if (root == null)
            return sum;

        sum = replaceWithLargerNodesSum(root.right, sum);
        sum += root.data;
        root.data = sum;
        sum = replaceWithLargerNodesSum(root.left, sum);
        return sum;
    }

    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        int sum = 0;
        replaceWithLargerNodesSum(root, sum);
    }
}
