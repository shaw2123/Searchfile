package Manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class manager {

    String path;
    String word;
    private final Scanner in = new Scanner(System.in);

    public int checkInputLimit(int min, int max) {
        try {
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(in.nextLine());
            if (choice < min || choice > max) {
                throw new NumberFormatException();
            }
            return choice;
        } catch (NumberFormatException ex) {
            System.err.println("Re-input");
        }
        return 0;
    }

    public int countWordInFile(String fileSource, String word) {
        FileReader fr = null;

        try {
            fr = new FileReader(fileSource);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public void getFileNameContainsWordInDirectory(String source, String word) {
        File folder = new File(source);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                    System.out.println("file name: " + file.getName());
                }
            }
        }
    }

    public void CountWord() {
        System.out.print("Enter Path: ");
        path = in.nextLine();
        System.out.print("Enter Word: ");
        word = in.nextLine();
        int count = countWordInFile(path, word);
        System.out.println("Count: " + count);
    }

    public void FindFile() {
        System.out.print("Enter Path: ");
        path = in.nextLine();
        System.out.print("Enter Word: ");
        word = in.nextLine();
        getFileNameContainsWordInDirectory(path, word);
    }
}
