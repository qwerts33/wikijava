package org.example;

import com.google.gson.Gson;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class WikiParser {
    public WikiResponse parseJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, WikiResponse.class);
    }
    public void printResults(WikiResponse response) {
        if (response.query.search.size() > 0) {
            int i = 1;
            for (Search item : response.query.search){
                System.out.println(i + ") " + item.title);
                i++;
            }
        } else {
            System.out.println("Статья не найдена. ");
        }
    }
    public void OpenBrowser(int pageid) throws Exception {
        String url = "https://ru.wikipedia.org/w/index.php?curid=" + pageid;
        Desktop.getDesktop().browse(new URI(url));
    }
}

class WikiResponse {
    public Query query;
}
class Query{
    public List<Search> search;
}
class Search {
    public String title;
    public String snippet;
    public int pageid;
}
