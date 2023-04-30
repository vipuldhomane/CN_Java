package Module2.LInkedLists2.Assignment;

public class EvenAfterOdd {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */

    public class Solution {

        public static Node<Integer> evenAfterOdd(Node<Integer> head) {

            if (head == null) {
                return head;
            }

            Node<Integer> evenHead = null, oddHead = null, evenTail = null, oddTail = null;

            while (head != null) {
                if (head.data % 2 == 0) {
                    if (evenHead == null) {
                        evenHead = head;
                        evenTail = head;
                    } else {
                        evenTail.next = head;
                        evenTail = evenTail.next;
                    }
                } else {
                    if (oddHead == null) {
                        oddHead = head;
                        oddTail = head;
                    } else {
                        oddTail.next = head;
                        oddTail = oddTail.next;
                    }
                }

                head = head.next;
            }

            if (oddHead == null) {
                return evenHead;
            } else {
                oddTail.next = evenHead;
            }

            if (evenHead != null) {
                evenTail.next = null;
            }

            return oddHead;
        }
    }
}
