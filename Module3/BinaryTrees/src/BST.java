/*
* building BST Class for using in abstraction
 */

public class BST {
    BinaryTreeNode<Integer> root;
    int size;

    // As the main function does not take bstnode as input argument using helper
    // function to call recursion
    public static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
        if (node == null) {
            return false;
        }
        if (node.data == x) {
            return true;
        }
        if (x < node.data) {
            return isPresentHelper(node.left, x);
        }
        return isPresentHelper(node.right, x);
    }

    public boolean isPresent(int x) {
        return isPresentHelper(root, x);
    }

    public static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
            return newRoot;
        }
        if (x >= root.data) {
            root.right = insertHelper(root.right, x);

        } else {
            root.left = insertHelper(root.left, x);
        }
        return root;
    }

    public void insert(int x) {
        root = insertHelper(root, x);
        size++;
    }

    public static int minimum(BinaryTreeNode<Integer> node) {
        if (node == null)
            return Integer.MAX_VALUE;
        int leftSmallest = minimum(node.left);
        int rightSmallest = minimum(node.right);
        return Math.min(node.data, Math.min(leftSmallest, rightSmallest));
    }

    public static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x) {
        // Base case
        if (root == null) {
            return new BSTDeleteReturn(null, false);
        }
        // Case 1 root data < x call on right side
        if (root.data < x) {
            BSTDeleteReturn outputRight = deleteDataHelper(root.right, x);
            root.right = outputRight.root;
            outputRight.root = root;
            return outputRight;
        }
        // Case 2 root data > x call on left side
        if (root.data > x) {
            BSTDeleteReturn outputLeft = deleteDataHelper(root.left, x);
            root.left = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }
        // Case 4
        // Sub Case 1 root with no child
        if (root.left == null && root.right == null) {
            return new BSTDeleteReturn(null, true);
        }
        // Sub Case 3 root with 1 child
        // left child
        if (root.left != null && root.right == null) {
            return new BSTDeleteReturn(root.left, true);
        }
        // right child
        if (root.left == null && root.right != null) {
            return new BSTDeleteReturn(root.right, true);
        }
        // having 2 child
        // find the minimum on right side
        int rightMin = minimum(root.right);
        root.data = rightMin;
        BSTDeleteReturn outputRight = deleteDataHelper(root.right, rightMin);
        root.right = outputRight.root;
        return new BSTDeleteReturn(root, true);
    }

    public boolean deleteData(int x) {
        BSTDeleteReturn output = deleteDataHelper(root, x);
        root = output.root;
        if (output.deleted) {
            size--;
        }
        return output.deleted;
    }

    public int size() {
        return size;
    }

    private void printTree(BinaryTreeNode<Integer> node) {
        // Pre order Traversal
        if (node == null)
            return;
        System.out.print(node.data + ":");
        if (node.left != null) {
            System.out.print("L" + node.left.data + ",");
        }
        if (node.right != null) {
            System.out.print("R" + node.right.data);
        }
        System.out.println();
        printTree(node.left);
        printTree(node.right);

    }

    public void print() {
        printTree(root);

    }
}
