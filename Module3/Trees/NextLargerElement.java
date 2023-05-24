package Module3.Trees;

import javax.lang.model.type.IntersectionType;

import Module2.Recursion.recursion;

public class NextLargerElement {

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }

        TreeNode<Integer> nextLargerNode = null;
        if (root.data > n) {
            nextLargerNode = root;
        }

        for (TreeNode<Integer> child : root.children) {
            TreeNode<Integer> nextLargerInChild = findNextLargerNode(child, n);
            if (nextLargerInChild != null) {
                if (nextLargerNode == null || nextLargerNode.data > nextLargerInChild.data) {
                    nextLargerNode = nextLargerInChild;
                }
            }
        }
        return nextLargerNode;
    }

    public static TreeNode<Integer> nextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> nextLargestNode = null;
        // check if root data > n. if yes then update the value
        if (root.data > n) {
            nextLargestNode = root;
        }
        // check on child using recursion
        for (TreeNode<Integer> child : root.children) {
            TreeNode<Integer> nextLargestChild = nextLargerNode(child, n);
            if (nextLargestChild != null) {
                if (nextLargestNode == null || nextLargestChild.data < nextLargestNode.data) {
                    nextLargestNode = nextLargestChild;
                }
            }
        }
        return nextLargestNode;

    }
}
