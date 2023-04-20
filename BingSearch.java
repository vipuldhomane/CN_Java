
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BingSearch {

    public static void main(String[] args) {
        // An example of a string array with some search queries
        String[] queries = { "java tutrial", "bing seach api", "how o use markdown", "bs", "jva tu", "bng api",
                "how  markdwn", "ajjs", " tutorkil", "bing sarch ", "how lto use marown", "lab" };

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