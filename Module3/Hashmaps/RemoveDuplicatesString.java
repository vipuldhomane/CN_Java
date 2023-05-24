package Module3.Hashmaps;

import java.util.*;

public class RemoveDuplicatesString {
    public static String removeDuplicates(String input) {
        // Create a HashSet to store the characters that have been seen
        HashSet<Character> seen = new HashSet<>();
        // Create a StringBuilder to store the output string
        StringBuilder output = new StringBuilder();
        // Loop through each character in the input string
        for (char c : input.toCharArray()) {
            // If the character has not been seen before, add it to the output and the
            // HashSet
            if (!seen.contains(c)) {
                output.append(c);
                seen.add(c);
            }
        }
        // Return the output string
        return output.toString();
    }

    public static void main(String[] args) {
        String str = "codingninjas";
        System.out.println(uniqueChar(str));
        System.out.println(removeDuplicates(str));
    }

}
