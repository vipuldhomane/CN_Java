import java.util.*;

public class BinarySearchTree extends BinaryTreeUse {
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

    // ================================================================================================//
    // Check if Balanced tree;
    public static boolean checkBST1(BinaryTreeNode<Integer> root) {
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
        boolean isLeftBalanced = checkBST1(root.left);
        boolean isRightBalanced = checkBST1(root.right);
        return isLeftBalanced && isRightBalanced;
    }

    // Better Version of Check BST with better time complexity

    public static isBSTReturn checkBSTBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            isBSTReturn ans = new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }

        isBSTReturn leftAns = checkBSTBetter(root.left);
        isBSTReturn rightAns = checkBSTBetter(root.right);

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));

        boolean isBST = true;

        if (leftAns.max >= root.data) {
            isBST = false;
        }
        if (rightAns.min < root.data) {
            isBST = false;
        }
        if (!leftAns.isBST) {
            isBST = false;
        }
        if (!rightAns.isBST) {
            isBST = false;
        }
        isBSTReturn ans = new isBSTReturn(min, max, isBST);
        return ans;
    }

    // Another Approach to checkBST
    public static boolean isBST3(BinaryTreeNode<Integer> root) {
        return isBST3Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST3Helper(BinaryTreeNode<Integer> root, int minRange, int maxRange) {
        if (root == null) {
            return true;
        }
        if (root.data < minRange || root.data > maxRange) {
            return false;
        }
        boolean isLeftBalanced = isBST3Helper(root.left, minRange, root.data - 1);
        boolean isRightBalanced = isBST3Helper(root.right, root.data, maxRange);

        return isLeftBalanced && isRightBalanced;

    }

    // Assignments
    // =================================================================================//
    // BST to LL
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        return constructLinkedListHelper(root).head;
    }

    private static PairOfNodeElem constructLinkedListHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            PairOfNodeElem pair = new PairOfNodeElem();
            return pair;
        }

        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);
        PairOfNodeElem leftList = constructLinkedListHelper(root.left);
        PairOfNodeElem rightList = constructLinkedListHelper(root.right);
        PairOfNodeElem pair = new PairOfNodeElem();
        if (leftList.tail != null) {
            leftList.tail.next = newNode;
        }

        newNode.next = rightList.head;

        if (leftList.head != null) {
            pair.head = leftList.head;
        } else {
            pair.head = newNode;
        }

        if (rightList.tail != null) {
            pair.tail = rightList.tail;
        } else {
            pair.tail = newNode;
        }
        return pair;
    }

    // Function to print LL
    public static void printR(LinkedListNode<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printR(head.next);
    }

    // ==========================================================================================//

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

    // ==================================================================================//

    // CN code
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

    // ==============================================================================================//
    // BST 2 module

    // Find path from Node to Linked List (Non BST)
    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return null;
        }
        if (root.data == x) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
        if (leftOutput != null) {
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
        if (rightOutput != null) {
            rightOutput.add(root.data);
            return rightOutput;
        }
        return null;

    }

    // For BST Only
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (root == null) {
            return null;

        }
        if (root.data == data) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }
        // case 2
        if (root.data > data) {
            ArrayList<Integer> leftOutput = getPath(root.left, data);
            if (leftOutput != null) {
                leftOutput.add(root.data);
                return leftOutput;
            }
        }
        // case 3
        if (root.data < data) {
            ArrayList<Integer> rightOutput = getPath(root.right, data);
            if (rightOutput != null) {
                rightOutput.add(root.data);
                return rightOutput;
            }
        }
        return null;

    }

    // ==========================================================================================//
    // inset into BST
    public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
            return newRoot;
        }
        if (x >= root.data) {
            root.right = insert(root.right, x);

        } else {
            root.left = insert(root.left, x);
        }
        return root;

    }

    public static void main(String[] args) {
        int in[] = { 1, 2, 3, 4, 5, 6, 7 };
        int pre[] = { 4, 2, 1, 3, 6, 5, 7 };
        // BinaryTreeNode<Integer> root = takeInputLevelwise();
        BinaryTreeNode<Integer> root = buildTreePreIn(pre, in);
        printLevelWise(root);
        insert(root, 8);
        printLevelWise(root);

        // // printInRangeK1K2(root, 3, 6);
        // // System.out.println(searchBST(root, 56));
        // int arr[] = { 30, 40, 45, 50, 60, 70, 80 };
        // BinaryTreeNode<Integer> root = SortedArrayToBST(arr, arr.length);
        // printLevelWise(root);
        // System.out.println(checkBST1(root));
        // isBSTReturn ans = checkBSTBetter(root);
        // System.out.println(ans.min + " " + ans.max + " " + ans.isBST);
        // LinkedListNode<Integer> node = constructLinkedList(root);
        // printR(node);
        // ArrayList<Integer> path = nodeToRootPath(root, 7);
        // for (int i : path) {
        // System.out.println(i);
        // }
        // System.out.println(isBST(root));
    }
}
