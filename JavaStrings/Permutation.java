package JavaStrings;

public class Permutation {

    public static boolean isPermutation(String str1, String str2) {
        // Your code goes
        int arr1[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            int a = ((int) str1.charAt(i) - 97);
            arr1[a] += 1;
        }
        int arr2[] = new int[26];
        for (int i = 0; i < str2.length(); i++) {
            int a = ((int) str2.charAt(i) - 97);
            arr2[a] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aedbf";
        System.out.println(isPermutation(str1, str2));
    }

}