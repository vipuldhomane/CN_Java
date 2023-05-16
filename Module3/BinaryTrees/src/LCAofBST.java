public class LCAofBST {

    /*
     * Binary Tree Node class
     *
     * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
     * right;
     *
     * public BinaryTreeNode(T data) { this.data = data; } }
     */

    /*
     * Time complexity: O(H)
     * Space complexity: O(H)
     *
     * where H is the height of the input BST
     */

    public static BinaryTreeNode<Integer> getLCAUtil(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null || root.data == a || root.data == b) {
            return root;
        }
        if (root.data < a && root.data < b) {
            return getLCAUtil(root.right, a, b);
        } else if (root.data > a && root.data > b) {
            return getLCAUtil(root.left, a, b);
        }
        BinaryTreeNode<Integer> leftLCA = getLCAUtil(root.left, a, b);
        BinaryTreeNode<Integer> rightLCA = getLCAUtil(root.right, a, b);
        if (leftLCA != null && rightLCA != null) {
            return root;
        } else if (leftLCA != null) {
            return leftLCA;
        }
        return rightLCA;

    }

    public static int getLCACN(BinaryTreeNode<Integer> root, int a, int b) {
        BinaryTreeNode<Integer> node = getLCAUtil(root, a, b);
        return (node == null) ? -1 : node.data;
    }

    // Another Approach
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

        if (root == null) {
            return -1;
        }
        if (a < root.data && b < root.data) {
            return getLCA(root.left, a, b);
        }
        if (a > root.data && b > root.data) {
            return getLCA(root.right, a, b);
        }
        if (root.data == a || root.data == b) {
            return root.data;
        }
        int leftLca = getLCA(root.left, a, b);
        int rightLca = getLCA(root.right, a, b);
        if (leftLca == -1 && rightLca == -1) {
            return -1;
        } else if (leftLca == -1) {
            return rightLca;
        } else if (rightLca == -1) {
            return leftLca;
        } else {
            return root.data;
        }

    }

    // simplest approach
    public static int LCAofBST(BinaryTreeNode<Integer> root, int n1, int n2) {
        // base case
        if (root == null) {
            return -1;
        }
        // If node's value is greater than both n1 and n2,
        // then LCA lies in the left subtree
        if (root.data > n1 && root.data > n2) {
            return LCAofBST(root.left, n1, n2);
        }

        // case 2
        // If node's value is lesser than both n1 and n2
        // then LCA lies in the right subtree
        if (root.data < n1 && root.data < n2) {
            return LCAofBST(root.right, n1, n2);
        }
        // Otherwise, node is the LCA (assuming that both n1 and n2 exist in the BST)
        // Return node's value
        return root.data;

    }
}
