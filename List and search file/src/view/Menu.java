package view;

import Manager.manager;
import java.util.Scanner;

public class Menu {

    manager mane = new manager();
    private final Scanner in = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("1. Count Word In File");
            System.out.println("2. Find File By Word");
            System.out.println("3. Exit");
            int choice = mane.checkInputLimit(1, 3);
            switch (choice) {
                case 1:
                    mane.CountWord();
                    break;
                case 2:
                    mane.FindFile();
                    break;
                case 3:
                    return;
            }
        }
    }

}
