package Module2.Assignments;

public class GeometricSum {
    public static double findGeometricSum(int k) {
        if (k == 0) {
            return 1;
        }
        double ans = (1 / Math.pow(2, k));
        double smallans = findGeometricSum(k - 1);

        ans = ans + smallans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.format("%.5f", findGeometricSum(4));
        // System.out.println();
    }
}
