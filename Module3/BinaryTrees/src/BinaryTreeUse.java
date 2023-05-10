import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.naming.Binding;

public class BinaryTreeUse {
    // take input levelwise
    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter rootData");
        int rootdata = s.nextInt();
        if (rootdata == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);
        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter left Child of " + front.data);
            int leftdata = s.nextInt();
            if (leftdata != -1) {
                BinaryTreeNode<Integer> leftchild = new BinaryTreeNode<Integer>(leftdata);
                front.left = leftchild;
                pendingChildren.add(leftchild);
            }
            System.out.println("Enter right Child of " + front.data);
            int rightdata = s.nextInt();
            if (rightdata != -1) {
                BinaryTreeNode<Integer> rightchild = new BinaryTreeNode<Integer>(rightdata);
                front.right = rightchild;
                pendingChildren.add(rightchild);
            }
        }
        return root;
    }

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

    public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root) {
        // base
        if (root == null) {
            return null;
        }
        // identify leaf
        if (root.left == null && root.left == null) {
            return null;
        }
        root.left = removeLeaf(root.left);
        root.right = removeLeaf(root.right);
        return root;

    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null)
            return;
        // if(root.left==null && root.right==null)
        // return;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        // base case
        if (root == null)
            return true;

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        if (Math.abs(leftheight - rightheight) > 1) {
            return false;
        }
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        return isLeftBalanced && isRightBalanced;
    }

    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = 0;
            ans.isBalanced = true;
            return ans;
        }
        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);

        int height = 1 + Math.max(leftOutput.height, rightOutput.height);
        boolean isBal = true;

        if (Math.abs(leftOutput.height - rightOutput.height) > 1) {
            isBal = false;
        }
        if (!leftOutput.isBalanced || !rightOutput.isBalanced) {
            isBal = false;
        }
        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;

    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        // Your code goes here
        if (root == null) {
            return 0;
        }
        return 1 + height(root.left) + height(root.right);
    }
    // Diameter of Binary Tree CN Solution

    private static Pair diameterHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair pair = new Pair(0, 0);
            return pair;
        }

        Pair leftPair = diameterHelper(root.left);
        Pair rightPair = diameterHelper(root.right);

        int leftDiameter = leftPair.diameter;
        int rightDiameter = rightPair.diameter;

        /*
         * 'dist' denotes the longest distance between
         * deepest node of the left subtree and
         * deepest node of the right subtree
         */
        int dist = leftPair.height + rightPair.height + 1;

        int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));
        int height = Math.max(leftPair.height, rightPair.height) + 1;

        return (new Pair(diameter, height));
    }

    public static int diameterOfBinaryTree1(BinaryTreeNode<Integer> root) {
        Pair pair = diameterHelper(root);
        return pair.diameter;
    }

    // print levelWise
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> nodestoPrint = new LinkedList<>();
        nodestoPrint.add(root);
        while (!nodestoPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodestoPrint.poll();
            System.out.print(front.data + ":");

            // Checking for childs
            if (front.left != null) {
                nodestoPrint.add(front.left);
                System.out.print("L:" + front.left.data);
            } else {
                System.out.print("L:-1");
            }
            if (front.right != null) {
                nodestoPrint.add(front.right);
                System.out.print(",R:" + front.right.data);
            } else {
                System.out.print(",R:-1");
            }
            System.out.println();
        }
    }

    public static BinaryTreeNode<Integer> buildTreePreInHelper(int pre[], int in[], int siPre, int eiPre, int siIn,
            int eiIn) {
        if (siPre > eiPre) {
            return null;
        }
        int rootdata = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);

        // Find Root Index in IN
        int rootindex = -1;
        for (int i = siIn; i <= eiIn; i++) {
            if (in[i] == rootdata) {
                rootindex = i;
                break;

            }
        }

        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootindex - 1;
        int siInRight = rootindex + 1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;

        int leftsubtreelen = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftsubtreelen - 1;
        int siPreRight = eiPreLeft + 1;
        BinaryTreeNode<Integer> left = buildTreePreInHelper(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        BinaryTreeNode<Integer> right = buildTreePreInHelper(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);

        root.left = left;
        root.right = right;
        return root;
    }

    public static BinaryTreeNode<Integer> buildTreePreIn(int pre[], int in[]) {
        BinaryTreeNode<Integer> root = buildTreePreInHelper(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        // Your code goes here
        BinaryTreeNode<Integer> root = buildTree(postOrder, inOrder, 0, postOrder.length - 1, 0, inOrder.length - 1);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder, int siPost, int eiPost, int siIn,
            int eiIn) {
        // TODO Auto-generated method stub

        // Base case - If number of elements in the post-order is 0
        if (siPost > eiPost) {
            return null;
        }

        // Defining the root node for current recursion
        int rootData = postOrder[eiPost];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

        // Finding root data's location in Inorder (Assuming root data exists in
        // Inorder)
        int rootIndex = -1;
        for (int i = siIn; i <= eiIn; i++) {
            if (rootData == inOrder[i]) {
                rootIndex = i;
                break;
            }
        }

        // Defining index limits for Left Subtree Inorder
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;

        // Defining the index limits for Left Subtree Preorder
        int siPostLeft = siPost;
        int leftSubTreeLength = eiInLeft - siInLeft + 1;
        int eiPostLeft = (siPostLeft) + (leftSubTreeLength - 1);

        // Defining index limits for Right Subtree Inorder
        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;

        // Defining index limits for Right Subtree Preorder
        int siPostRight = eiPostLeft + 1;
        int eiPostRight = eiPost - 1;

        BinaryTreeNode<Integer> rightChild = buildTree(postOrder, inOrder, siPostRight, eiPostRight, siInRight,
                eiInRight);
        BinaryTreeNode<Integer> leftChild = buildTree(postOrder, inOrder, siPostLeft, eiPostLeft, siInLeft, eiInLeft);

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    /*
     * =============================================================================
     * =======================
     */
    // Assignments

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
        BinaryTreeNode<Integer> Node = new BinaryTreeNode<Integer>(root.data);
        BinaryTreeNode<Integer> temp = root.left;

        root.left = Node;
        Node.left = temp;

    }

    // This Function wont work because pair file does not exist in folder
    // see in Assignments folder
    public static PairMinMax<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return new PairMinMax<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        PairMinMax<Integer, Integer> leftPair = getMinAndMax(root.left);
        PairMinMax<Integer, Integer> rightPair = getMinAndMax(root.right);

        int minimum = Math.min(root.data, Math.min(leftPair.minimum, rightPair.minimum));
        int maximum = Math.max(root.data, Math.max(leftPair.maximum, rightPair.maximum));

        return new PairMinMax<>(minimum, maximum);

    }

    // Level Order Traversal
    // Print Level Wise
    public static void printLevelWiseAssignment(BinaryTreeNode<Integer> root) {
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

    // Assignment Problem
    // Path Sum Root to LeafMinMax
    public static void leafSumPathHelper(BinaryTreeNode<Integer> root, int k, String str) {
        if (root == null) {
            return;

        }
        int rootdata = root.data;

        str += rootdata + " ";
        if (k == rootdata && root.left == null && root.right == null) {
            System.out.println(str);
            return;
        }
        leafSumPathHelper(root.left, k - rootdata, str);
        leafSumPathHelper(root.right, k - rootdata, str);
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        // Your code goes here
        String str = "";
        leafSumPathHelper(root, k, str);
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
        // BinaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printTree(root);
        System.out.println(numNodes(root));
        System.out.println(largest(root));
        System.out.println(numLeafs(root));
    }
}
