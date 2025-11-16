package org.example;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class WikiRequest {
    String buildURL(String input) throws Exception {
        String encodedInput = URLEncoder.encode(input, "UTF-8");
        String url = "https://ru.wikipedia.org/w/api.php?action=" +
                "query&list=search&utf8=&format=json&srsearch=" + encodedInput;
        return url;
    }
    String sendRequest(String url) throws Exception {
        URL requestURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) requestURL.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)");
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine())!=null) {
            response.append(line);
        }
        bufferedReader.close();
        inputStream.close();
        connection.disconnect();
        String jsonString = response.toString();
        return jsonString;
    }
}
