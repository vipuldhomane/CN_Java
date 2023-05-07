package Module2.Stacks;

public class StackUse {
    public static void main(String[] args) throws StackEmptyException, StackFullException {

        // StackUsingArray stack = new StackUsingArray(2);
        StacksUsingLL<Integer> stack = new StacksUsingLL<>();
        int arr[] = { 1, 23, 8, 4, 5, 7, 5, 4, 8, 7, 5, 4 };

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

}
