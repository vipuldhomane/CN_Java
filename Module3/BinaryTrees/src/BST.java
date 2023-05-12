
public class BST extends BinaryTreeUse {
    public static boolean searchBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return false;
        }
        if (root.data == k) {
            return true;
        }
        if (k < root.data) {
            return searchBST(root.left, k);
        }
        return searchBST(root.right, k);
    }

    public static void printInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data < k1) {
            printInRangeK1K2(root.right, k1, k2);
        } else if (root.data > k2) {
            printInRangeK1K2(root.left, k1, k2);
        } else {
            System.out.print(root.data + " ");
            printInRangeK1K2(root.left, k1, k2);
            printInRangeK1K2(root.right, k1, k2);
        }

    }

    // Assignment Problem
    /*
     * Given a Binary Search Tree and two integers k1 and k2, find and print the
     * elements which are in range k1 and k2 (both inclusive).
     */
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            elementsInRangeK1K2(root.left, k1, k2);
            System.out.print(root.data + " ");
            elementsInRangeK1K2(root.right, k1, k2);
        }
        if (root.data < k1) {
            elementsInRangeK1K2(root.right, k1, k2);
        }
        if (root.data > k2) {
            elementsInRangeK1K2(root.left, k1, k2);
        }
    }
    // ============================================================================================//
    // Build tree using Sorted Array

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        return SortedArrayToBSTHelper(arr, 0, n - 1);
    }

    // helper
    public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int si, int ei) {

        if (si > ei) {
            return null;
        }
        // finding mid
        int mid = (si + ei) / 2;
        // create a node with mid
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);

        // build rest of the tree using recursion

        root.left = SortedArrayToBSTHelper(arr, si, mid - 1);
        root.right = SortedArrayToBSTHelper(arr, mid + 1, ei);
        return root;
    }

    // Check if Balanced tree;
    public static boolean checkBST(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftMax = maximum(root.left);
        if (leftMax >= root.data) {
            return false;
        }
        int rightMin = minimum(root.right);
        if (rightMin < root.data) {
            return false;
        }
        boolean isLeftBalanced = checkBST(root.left);
        boolean isRightBalanced = checkBST(root.right);
        return isLeftBalanced && isRightBalanced;
    }

    public static void main(String[] args) {
        int in[] = { 1, 2, 3, 4, 5, 6, 7 };
        int pre[] = { 4, 2, 1, 3, 6, 5, 7 };

        // BinaryTreeNode<Integer> root = buildTreePreIn(pre, in);
        // printLevelWise(root);
        // printInRangeK1K2(root, 3, 6);
        // System.out.println(searchBST(root, 56));
        int arr[] = { 30, 40, 45, 50, 60, 70, 80 };
        BinaryTreeNode<Integer> root = SortedArrayToBST(arr, arr.length);
        printLevelWise(root);
        System.out.println(checkBST(root));
    }
}
