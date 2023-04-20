package Functions;

public class EvenNumtillN {
    public static int[] avgtillN(int x) {
        int avg[] = new int[x / 2];
        for (int i = 0; i < x; i++) {
            if (i % 2 == 0) {
                avg[i] = (i + 1) * 2;
            }
        }
        return avg;
    }

    public static void main(String[] args) {
        int avg[] = avgtillN(50);
        for (int i = 0; i < avg.length; i++) {
            System.out.print(avg[i] + " ");
        }
    }
}
