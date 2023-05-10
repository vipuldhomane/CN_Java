public class GetMinMax {

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

}
