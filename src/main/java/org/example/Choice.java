package org.example;

import java.util.Scanner;

public class Choice {
    int SelectedChoice(int max) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {
            System.out.print("Введите номер статьи для открытия (1-" + max + "): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            if (choice > 0 && choice < 11) {
                return choice;
            } else {
                System.out.println("Ошибка: такого варианта нет.");
            }
        }
    }
}
