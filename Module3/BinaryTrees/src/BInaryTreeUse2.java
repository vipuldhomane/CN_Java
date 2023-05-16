
public class BInaryTreeUse2 extends BinaryTreeUse {
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

    // Build Tree using Inorder and Preorder
    // use a helper function
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

    public static void main(String[] args) {
        int pre[] = { 1, 2, 4, 5, 3 };
        int in[] = { 4, 2, 5, 1, 3 };
        BinaryTreeNode<Integer> root = buildTreePreIn(pre, in);
        // BinaryTreeNode<Integer> newroot = removeLeaf(root);
        printTree(root);

    }
}
