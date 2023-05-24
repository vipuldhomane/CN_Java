import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

class bstSubtreeReturn {
    int max;
    int min;
    int height;
    boolean isBST;
}

public class LargestBSTHeight extends BinarySearchTree {
    /*
     * Time complexity: O(N)
     * Space complexity: O(H)
     * 
     * where N is the number of nodes in the input BST
     * and H is the height of the input BST
     */

    public static bstSubtreeReturn largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            bstSubtreeReturn ans = new bstSubtreeReturn();
            ans.max = Integer.MIN_VALUE;
            ans.min = Integer.MAX_VALUE;
            ans.isBST = true;
            ans.height = 0;
            return ans;
        }
        bstSubtreeReturn left = largestBSTSubtreeHelper(root.left);
        bstSubtreeReturn right = largestBSTSubtreeHelper(root.right);
        if (!(right.isBST && right.min > root.data)) {
            right.isBST = false;
        }
        if (!(left.isBST && left.max < root.data)) {
            left.isBST = false;
        }
        bstSubtreeReturn ans = new bstSubtreeReturn();
        if (!left.isBST || !right.isBST || root.data < left.max || root.data > right.min) {
            if (left.height > right.height) {
                left.isBST = false;
                return left;
            } else {
                right.isBST = false;
                return right;
            }
        }
        ans.isBST = true;
        ans.min = Math.min(left.min, Math.min(right.min, root.data));
        ans.max = Math.max(left.max, Math.max(right.max, root.data));
        ans.height = Math.max(left.height, right.height) + 1;
        return ans;
    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBSTSubtreeHelper(root).height;
    }

    // Simplified version

    public static bstSubtreeReturn largestBSTSubtreeHelper1(BinaryTreeNode<Integer> root) {
        if (root == null) {
            bstSubtreeReturn ans = new bstSubtreeReturn();
            ans.max = Integer.MIN_VALUE;
            ans.min = Integer.MAX_VALUE;
            ans.isBST = true;
            ans.height = 0;
            return ans;
        }

        bstSubtreeReturn left = largestBSTSubtreeHelper1(root.left);
        bstSubtreeReturn right = largestBSTSubtreeHelper1(root.right);

        bstSubtreeReturn ans = new bstSubtreeReturn();
        ans.min = Math.min(left.min, Math.min(right.min, root.data));
        ans.max = Math.max(left.max, Math.max(right.max, root.data));
        ans.height = Math.max(left.height, right.height) + 1;

        if (!(left.isBST && right.isBST && root.data > left.max && root.data < right.min)) {
            ans.isBST = false;
            return ans;
        }

        ans.isBST = true;
        return ans;
    }

    // Better Approach
    // https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
    public static int[] largestBSTBT(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        if (root.left == null && root.right == null) {
            return new int[] { root.data, root.data, 1 };
        }

        int[] left = largestBSTBT(root.left);
        int[] right = largestBSTBT(root.right);

        int[] ans = new int[3];

        if ((left[2] > 0) && (right[2] > 0) && (left[1] < root.data) && (right[0] > root.data)) {
            ans[0] = Math.min(left[0], Math.min(right[0], root.data));
            ans[1] = Math.max(right[1], Math.max(left[1], root.data));
            ans[2] = 1 + Math.max(left[2], right[2]);
        } else {
            ans[0] = Integer.MIN_VALUE;
            ans[1] = Integer.MAX_VALUE;
            ans[2] = Math.max(left[2], right[2]);
        }

        return ans;
    }

    public static int largestBSTBTutil(BinaryTreeNode<Integer> root) {
        return largestBSTBT(root)[2];
    }

    public static void main(String[] args) {
        int[] pre = { 50, 40, 30, 45, 60, 65, 70 };
        int[] in = { 30, 40, 45, 50, 65, 60, 70 };
        BinaryTreeNode<Integer> root = buildTreePreIn(pre, in);
        printLevelWise(root);
        System.out.println(largestBSTSubtree(root));
        System.out.println(largestBSTBTutil(root));
        // System.out.println();

    }

}
