import java.util.Scanner;

import Module2.LInkedLists2.Assignment.KReverse;

public class BinaryTreeUse {
    public static BinaryTreeNode<Integer> takeInputBetter(boolean isroot, int parentdata, boolean isleft) {
        if (isroot) {
            System.out.println("Enter root data");
        } else {
            if (isleft) {
                System.out.println("Enter Left Child of " + parentdata);
            } else {
                System.out.println("Enter Right Child of " + parentdata);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootdata = s.nextInt();
        // Base case
        if (rootdata == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        BinaryTreeNode<Integer> leftChild = takeInputBetter(false, rootdata, true);
        BinaryTreeNode<Integer> rightChild = takeInputBetter(false, rootdata, false);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static BinaryTreeNode<Integer> takeInput() {
        System.out.println("Enter root data");
        Scanner s = new Scanner(System.in);
        int rootdata = s.nextInt();
        // Base case
        if (rootdata == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        BinaryTreeNode<Integer> leftChild = takeInput();
        BinaryTreeNode<Integer> rightChild = takeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root) {
        // Pre order Traversal
        if (root == null)
            return;
        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("L" + root.left.data + ",");
        }
        if (root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println();
        printTree(root.left);
        printTree(root.right);

    }

    public static void inOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    // A program for Postorder Traversal
    public static void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static int numNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;

        }
        int leftNodeCount = numNodes(root.left);
        int rightNodeCount = numNodes(root.right);
        return 1 + leftNodeCount + rightNodeCount;

    }

    public static int getSum(BinaryTreeNode<Integer> root) {
        // Your code goes here.
        if (root == null) {
            return 0;
        }
        int leftdata = getSum(root.left);
        int rightdata = getSum(root.right);
        int sum = root.data + leftdata + rightdata;
        return sum;
    }

    public static int largest(BinaryTreeNode<Integer> root) {
        if (root == null)
            return -1;

        int leftLargest = largest(root.left);
        int rightLargest = largest(root.right);

        return Math.max(root.data, Math.max(leftLargest, rightLargest));

    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodesGreaterThanX(root.left, x);
        int rightCount = countNodesGreaterThanX(root.right, x);
        if (root.data > x) {
            return 1 + leftCount + rightCount;
        } else {
            return leftCount + rightCount;
        }
    }

    // Height of BT
    public static int height(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return 1 + Math.max(leftheight, rightheight);
    }

    // Number of Leafs
    public static int numLeafs(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        return numLeafs(root.left) + numLeafs(root.right);

    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        } else if (root.data == x) {
            return true;
        } else {
            return (isNodePresent(root.left, x) || isNodePresent(root.right, x));
        }
    }

    // Depth
    public static void printatDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return;
        if (root.data == k) {
            System.out.println(root.data);
            return;
        }
        printatDepthK(root.left, k - 1);
        printatDepthK(root.right, k - 1);
    }

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return;
        }
        if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
        }
        if (root.left == null && root.right != null) {
            System.out.print(root.right.data + " ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    public static void main(String[] args) {

        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
        // BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
        // BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
        // root.left = rootLeft;
        // root.right = rootRight;
        // BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
        // BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
        // rootLeft.right = twoRight;
        // rootRight.left = threeLeft;
        BinaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
        printTree(root);
        System.out.println(numNodes(root));
        System.out.println(largest(root));
        System.out.println(numLeafs(root));
    }
}
