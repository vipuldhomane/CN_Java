
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

public class BingSearchcopy {

    public static String[] generateRandomWords(int numberOfWords) {
        // Create an array to store the random words
        String[] randomStrings = new String[numberOfWords];
        // Create a Random object to generate random numbers
        Random random = new Random();
        // Loop through the array and generate random words
        for (int i = 0; i < numberOfWords; i++) {
            // Create a char array to store the random characters
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10
            // Loop through the char array and generate random characters
            for (int j = 0; j < word.length; j++) {
                // Generate a random number between 'a' and 'z' and cast it to char
                word[j] = (char) ('a' + random.nextInt(26));
            }
            // Convert the char array to a String and store it in the array
            randomStrings[i] = new String(word);
        }
        // Return the array of random words
        return randomStrings;
    }

    public static void main(String[] args) {
        // An example of a string array with some search queries

        // String str1[] = generateRandomWords(10);
        // String[] queries = { "java tutrial", "bing seach api", "how o use markdown",
        // "bs", "jva tu", "bng api",
        // "how markdwn", "ajjs", " tutorkil", "bing sarch ", "how lto use marown",
        // "lab" };
        String queries[] = generateRandomWords(10);

        // Loop through the array and search each query on bing.com
        for (String query : queries) {
            // Encode the query to make it URL-friendly
            String encodedQuery = query.replace(" ", "+");

            // Construct the URL for bing.com with the query parameter
            String url = "https://www.bing.com/search?q=" + encodedQuery;

            // Try to open the URL in the default browser
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // Handle any exceptions
                e.printStackTrace();
            }
        }
    }
}