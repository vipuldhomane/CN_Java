package Module3.Trees;

public class ReplaceWithDepth {
    public static void replaceWithDepthValue(TreeNode<Integer> root) {

        // Write your code here
        if (root == null) {
            return;
        }
        replaceWithDepthValue(root, 0);

    }

    public static void replaceWithDepthValue(TreeNode<Integer> root, int depth) {
        root.data = depth;
        for (TreeNode<Integer> child : root.children) {
            replaceWithDepthValue(child, depth + 1);
        }
    }
}
