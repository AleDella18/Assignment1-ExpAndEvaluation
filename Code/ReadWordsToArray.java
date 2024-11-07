package Code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWordsToArray {

    public static String[] function(String s) {

        ArrayList<String> wordList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(s))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    wordList.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        // Convert ArrayList to array
        return wordList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Replace with the actual absolute path
        String filePath = "/home/stipe/Experimentation & Evaluation/Assignment1-ExpAndEvaluation/words_directory/words_100.txt";
        String[] s = function(filePath);

        // Print the array to verify the contents
        System.out.println("Words in the array:");
        for (String word : s) {
            System.out.println(word);
        }
    }
}


