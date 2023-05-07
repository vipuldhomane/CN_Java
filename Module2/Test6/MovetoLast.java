package Module2.Test6;

import Module2.LinkedLists.Node;

public class MovetoLast {

    public static Node<Integer> func(Node<Integer> head, int n) {
        Node<Integer> temp = head, prev = null, last = null;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        last = temp;
        temp = head;
        // int flag=0;
        for (int i = 0; i < len; i++) {
            // flag=0;
            if (temp.data == n) {
                if (prev == null) {
                    Node<Integer> temp2 = new Node<Integer>(temp.data);
                    head = head.next;
                    last.next = temp2;
                    prev = null;
                    temp = head;
                } else {
                    Node<Integer> temp2 = new Node<Integer>(temp.data);
                    prev.next = temp.next;
                    last.next = temp2;

                    temp = temp.next;
                }
                last = last.next;
            }

            else {
                prev = temp;
                temp = temp.next;
            }

        }
        return head;
    }

}
