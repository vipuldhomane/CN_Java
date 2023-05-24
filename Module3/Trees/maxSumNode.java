// Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.

package Module3.Trees;

class Pair {
    TreeNode<Integer> node;
    int xSum;
}

public class maxSumNode {

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        // Write your code here

        if (root == null)
            return null;
        Pair ans = helper(root);
        return ans.node;
    }

    public static Pair helper(TreeNode<Integer> root) {
        Pair ans = new Pair();
        ans.node = root;
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum += root.children.get(i).data;
        }
        ans.xSum = sum;

        for (int i = 0; i < root.children.size(); i++) {
            Pair smallAns = helper(root.children.get(i));
            if (smallAns.xSum > ans.xSum) {
                ans.xSum = smallAns.xSum;
                ans.node = smallAns.node;
            }
        }
        return ans;
    }

}