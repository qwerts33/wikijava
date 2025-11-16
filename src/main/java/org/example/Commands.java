package org.example;

import java.util.Scanner;

public class Commands {
    void commands() throws Exception{
        TextScanner scanner = new TextScanner("");
        scanner.InputScanner();
        scanner.Print();
        String input = scanner.input;
        WikiRequest wikiRequest = new WikiRequest();
        String url = wikiRequest.buildURL(input);
        String json = wikiRequest.sendRequest(url);
        WikiParser wikiParser = new WikiParser();
        WikiResponse response = wikiParser.parseJson(json);
        wikiParser.printResults(response);
        if (response.query.search.size() == 0){
            System.out.print("Завершение работы.");
            return;
        }
        Choice choice = new Choice();
        int number = choice.SelectedChoice(response.query.search.size());
        Search selected = response.query.search.get(number-1);
        wikiParser.OpenBrowser(selected.pageid);
    }
}