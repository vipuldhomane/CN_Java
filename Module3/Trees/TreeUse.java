package Module3.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
    public static void printTree(TreeNode<Integer> root) {
        if (root == null) {
            // this is not a base case this is a Special Case
            return;
        }
        System.out.print(root.data + " : ");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            // base case will be taken care in the loop itself
            // if some node does not have children then the loop wont run itself
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }

    }

    public static int numberOfNodes(TreeNode<Integer> root) {

        int count = 1;
        // looping over each child. if node does does not have any child then the loop
        // wont run

        for (int i = 0; i < root.children.size(); i++) {
            int childrenCount = numberOfNodes(root.children.get(i));
            count += childrenCount;

        }
        return count;
    }

    public static int sumOfAllNode(TreeNode<Integer> root) {
        int sum = root.data;
        // looping over each child. if node does does not have any child then the loop
        // wont run

        for (int i = 0; i < root.children.size(); i++) {
            int childrenSum = sumOfAllNode(root.children.get(i));
            sum += childrenSum;

        }
        return sum;
    }

    public static TreeNode<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data");
        int rootData = sc.nextInt();
        if (rootData == -1) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> front = pendingNodes.poll();
            System.out.println("Enter the Number of Children for " + front.data);
            int numChild = sc.nextInt();
            // run the loop for numChild times
            for (int i = 0; i < numChild; i++) {
                System.out.println("Enter the " + i + "th child data for " + front.data);
                int childData = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<Integer>(childData);
                front.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        // TreeNode<Integer> nullNode = new TreeNode<Integer>(Integer.MIN_VALUE);
        q.add(root);
        q.add(null);
        System.out.println(root.data);
        while (q.size() != 1) {
            TreeNode<Integer> front = q.poll();

            if (front == null) {
                q.add(null);
                System.out.println();
                continue;
            }

            for (int i = 0; i < front.children.size(); ++i) {
                System.out.print(front.children.get(i).data + " ");
                q.add(front.children.get(i));
            }

        }
    }

    public static void printTreeLW(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        System.out.println(root.data);

        while (queue.size() != 1) {
            TreeNode<Integer> front = queue.poll();
            if (front == null) {
                queue.add(null);
                System.out.println();
                continue;
            }
            for (TreeNode<Integer> child : front.children) {
                System.out.print(child.data + " ");
                queue.add(child);
            }
        }

    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        int count = 0;
        if (root.data > x) {
            count++;
        }
        for (TreeNode<Integer> child : root.children) {
            int childCount = numNodeGreater(child, x);
            count += childCount;
        }
        return count;
    }

    public static int getHeight(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int maxHeight = 0;
        for (TreeNode<Integer> child : root.children) {
            int height = getHeight(child);
            maxHeight = Math.max(maxHeight, height);

        }
        return maxHeight + 1;
    }

    public static int countLeafNodes(TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        if (root.children.isEmpty()) {
            return 1;
        }
        int leafCount = 0;
        for (TreeNode<Integer> child : root.children) {
            leafCount += countLeafNodes(child);
        }
        return leafCount;
    }

    public static void printPostOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        for (TreeNode<Integer> child : root.children) {
            printLevelWise(child);
        }
        System.out.print(root.data);
    }

    // Check if generic tree contain element x
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        for (TreeNode<Integer> child : root.children) {
            checkIfContainsX(child, x);
        }
        return false;
    }

    // Structurally identical
    // Given two Generic trees, return true if they are structurally identical i.e.
    // they are made of nodes with the same values arranged in the same way.
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {

        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.children.size() != root2.children.size()) {
            return false;
        }
        if (!root1.data.equals(root2.data)) {
            return false;
        }
        for (int i = 0; i < root1.children.size(); i++) {
            TreeNode<Integer> child1 = root1.children.get(i);
            TreeNode<Integer> child2 = root2.children.get(i);
            if (!checkIdentical(child1, child2)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(4);
        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
        TreeNode<Integer> node3 = new TreeNode<Integer>(1);
        TreeNode<Integer> node4 = new TreeNode<Integer>(5);
        TreeNode<Integer> node5 = new TreeNode<Integer>(6);
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

        // printTree(root);
        // TreeNode<Integer> root1 = takeInput();
        // printTree(root1);
        // System.out.println(numberOfNodes(root1));
        // printLevelWise(root);
        printTreeLW(root);
        System.out.println(numNodeGreater(root, 4));
        System.out.println(checkIfContainsX(root, 7));
    }
}
