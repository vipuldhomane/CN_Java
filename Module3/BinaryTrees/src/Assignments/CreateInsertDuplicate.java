/*
Create & Insert Duplicate Node
Send Feedback
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
The root will remain the same. So you just need to insert nodes in the given Binary Tree.
 */
public class CreateInsertDuplicate {
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        // Your code goes here
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

}
