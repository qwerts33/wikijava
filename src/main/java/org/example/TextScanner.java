package org.example;
import java.util.Scanner;
public class TextScanner {
    public String input;
    Scanner scanner;
    public TextScanner(String input){
        this.input = input;
        this.scanner = new Scanner(System.in);
    }
    void InputScanner(){
        System.out.print("Введите запрос: ");
        this.input = scanner.nextLine();
    }
    void Print() {
        System.out.println("Ваш запрос: " + input);
    }
}
