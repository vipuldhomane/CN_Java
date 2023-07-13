package FullTest1;

import java.util.LinkedList;
import java.util.Queue;

class CNSolution {

    public static void showJumpingNos(int x) {
        System.out.print("0 ");
        for (int i = 1; i <= 9 && i <= x; i++) {
            bfsHelper(x, i);
        }
    }

    private static void bfsHelper(int x, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()) {
            num = q.remove();
            if (num <= x) {
                System.out.print(num + " ");
                int last = num;
                if (last == 0) {
                    q.add((num * 10) + (last + 1));
                } else if (last == 9) {
                    q.add((num * 10) + (last - 1));
                } else {
                    q.add((num * 10) + (last + 1));
                    q.add((num * 10) + (last - 1));
                }
            }
        }
    }

}

public class JumpingNum {
    public static void showJumpingNos(int x) {
        System.out.print("0 ");
        for (int i = 1; i <= 9 && i <= x; i++) {
            bfsHelper(x, i);
        }
    }

    private static void bfsHelper(int x, int i) {
        System.out.print(i + " ");
        int num = i;
        num = i * 10 + i;
        System.out.print(num - 1 + " ");
        System.out.print(num + 1 + " ");
    }

    public static void main(String[] args) {
        showJumpingNos(20);
    }
}
