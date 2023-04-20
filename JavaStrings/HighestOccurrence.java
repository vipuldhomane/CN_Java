package JavaStrings;

public class HighestOccurrence {
    public static char highestOccuringChar(String str) {
        // Sorting String in Matrix

        int mat[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int a = ((int) str.charAt(i) - 97);
            mat[a] += 1;
        }

        // Finding Highest occurring index
        int largestInd = 0;
        int largestNum = 0;
        for (int i = 0; i < 26; i++) {
            if (mat[i] > largestNum) {
                largestNum = mat[i];
                largestInd = i;
            }
        }
        return (char) (largestInd + 97);
    }

    public static void main(String[] args) {
        String str = "aabbccbbccc";
        System.out.println(highestOccuringChar(str));
    }
}
