package Functions;

public class FartoCel {
    public static void farToCel(int start, int end, int step) {
        for (int i = start; i <= end; i = i + step) {
            int c = (int) ((5.0 / 9.0) * (i - 32));
            System.out.println(i + " " + c);
        }

    }

    public static void main(String[] args) {
        farToCel(0, 100, 20);
    }

}
