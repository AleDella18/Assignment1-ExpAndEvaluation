package Code;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public interface Sorter_old<T extends Comparable<T>> {

    void sort(T[] items);

    static void exportToCSV(long[] times, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (long time : times) {
                writer.write(time + ",");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void main(String[] args) {

        /*long countBSUNC = 0;
        long countBSWN = 0;
        long countQSGPT = 0;
        long countSSGPT = 0;*/

        int iterations = 41;

        // Assertion for having an array of execution times when we can access directly
        // minimum, first quartile, median, third quartile, and maximum
        //assert iterations % 4 == 1;

        long[] arrayIntegers1 = new long[iterations];
        long[] arrayIntegers2 = new long[iterations];
        long[] arrayIntegers3 = new long[iterations];
        long[] arrayIntegers4 = new long[iterations];

        int smallSize = 100;
        int mediumSize = 10000;
        int largeSize = 20000;

        Integer[] testIntegersSmallArraySorted = new Integer[smallSize];
        for (int i = 0; i < smallSize; ++i) {
            testIntegersSmallArraySorted[i] = i;
        }
        Integer[] testIntegersSmallArrayReverseSorted = new Integer[smallSize];
        for (int i = 0; i < smallSize; ++i) {
            testIntegersSmallArrayReverseSorted[i] = smallSize - 1 - i;
        }
        Integer[] testIntegersSmallArrayRandom = new Integer[smallSize];
        for (int i = 0; i < smallSize; ++i) {
            testIntegersSmallArrayRandom[i] = (int)(Math.random() * smallSize);
        }

        Integer[] testIntegersMediumArraySorted = new Integer[mediumSize];
        for (int i = 0; i < mediumSize; ++i) {
            testIntegersMediumArraySorted[i] = i;
        }

        Integer[] testIntegersMediumArrayReverseSorted = new Integer[mediumSize];
        for (int i = 0; i < mediumSize; ++i) {
            testIntegersMediumArrayReverseSorted[i] = mediumSize - 1 - i;
        }

        Integer[] testIntegersMediumArrayRandom = new Integer[mediumSize];
        for (int i = 0; i < mediumSize; i++) {
            testIntegersMediumArrayRandom[i] = (int)(Math.random() * mediumSize);
        }

        Integer[] testIntegersLargeArraySorted = new Integer[largeSize];
        for (int i = 0; i < largeSize; ++i) {
            testIntegersLargeArraySorted[i] = i;
        }

        Integer[] testIntegersLargeArrayReverseSorted = new Integer[largeSize];
        for (int i = 0; i < largeSize; ++i) {
            testIntegersLargeArrayReverseSorted[i] = largeSize  - 1 - i;
        }

        Integer[] testIntegersLargeArrayRandom = new Integer[largeSize];
        for (int i = 0; i < largeSize; i++) {
            testIntegersLargeArrayRandom[i] = (int)(Math.random() * largeSize);
        }

        List<Integer[]> arrayListIntegers = new ArrayList<>();
        arrayListIntegers.add(testIntegersSmallArraySorted);
        arrayListIntegers.add(testIntegersSmallArrayReverseSorted);
        arrayListIntegers.add(testIntegersSmallArrayRandom);
        /*arrayListIntegers.add(testIntegersMediumArraySorted);
        arrayListIntegers.add(testIntegersMediumArrayReverseSorted);
        arrayListIntegers.add(testIntegersMediumArrayRandom);
        arrayListIntegers.add(testIntegersLargeArraySorted);
        arrayListIntegers.add(testIntegersLargeArrayReverseSorted);
        arrayListIntegers.add(testIntegersLargeArrayRandom);*/

        long[] arrayStrings1 = new long[iterations];
        long[] arrayStrings2 = new long[iterations];
        long[] arrayStrings3 = new long[iterations];
        long[] arrayStrings4 = new long[iterations];

        List<String> arrayListStrings = new ArrayList<>();

        // File paths
        String[] fileNames = {"./words_100.txt", "./words_10000.txt", "./words_100000.txt"};

        // Read each file and add words to the list
        for (String fileName : fileNames) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Split by whitespace to get individual words
                    String[] wordsInLine = line.split("\\s+");
                    for (String word : wordsInLine) {
                        if (!word.isEmpty()) {
                            arrayListStrings.add(word);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + fileName);
                e.printStackTrace();
            }
        }

        // Convert list to array for sorting
        String[] wordsArray = arrayListStrings.toArray(new String[0]);

        System.out.println();
        // Accessing and printing each array

        // Instances of the 4 algorithms
        BubbleSortUntilNoChange<Integer> BSUNCIntegers = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<Integer> BSWNIntegers = new BubbleSortWhileNeeded<>();
        QuickSortGPT<Integer> QSGPTIntegers = new QuickSortGPT<>();
        SelectionSortGPT<Integer> SSGPTIntegers = new SelectionSortGPT<>();

        long startTime;
        long endTime;
        long totalTime;

        for (Integer[] array : arrayListIntegers) {
            // Iterations
            // Print the formatted array
            /*System.out.print("Analysis for the array {");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}:");*/
            for (int i = 0; i < iterations; ++i) {

                startTime = System.nanoTime();
                BSUNCIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                arrayIntegers1[i] = totalTime;

                startTime = System.nanoTime();
                BSWNIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                arrayIntegers2[i] = totalTime;

                startTime = System.nanoTime();
                QSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                arrayIntegers3[i] = totalTime;

                startTime = System.nanoTime();
                SSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                arrayIntegers4[i] = totalTime;

                System.out.print("Iteration " + (i + 1) + ": Total time for BSUNC: " + arrayIntegers1[i]);
                System.out.print(" Total time for BSWN : " + arrayIntegers2[i]);
                System.out.print(" Total time for QSGPT : " + arrayIntegers3[i]);
                System.out.println(" Total time for SSGPT : " + arrayIntegers4[i]);
            }

            Arrays.sort(arrayIntegers1);
            Arrays.sort(arrayIntegers2);
            Arrays.sort(arrayIntegers3);
            Arrays.sort(arrayIntegers4);

            /*long min = Math.min(Math.min(arrayIntegers1[iterations/2], arrayIntegers2[iterations/2]), Math.min(arrayIntegers3[iterations/2], arrayIntegers4[iterations/2]));
            if (min == arrayIntegers1[iterations/2]) {
                ++countBSUNC;
            }
            else if (min == arrayIntegers2[iterations/2]) {
                ++countBSWN;
            }
            else if (min == arrayIntegers3[iterations/2]) {
                ++countQSGPT;
            }
            else {
                ++countSSGPT;
            }*/
            /*System.out.println("Minimum time for BSUNC : " + arrayIntegers1[0] + " First quartile time for BSUNC : " + arrayIntegers1[iterations/4] + " Median time for BSUNC : " + arrayIntegers1[iterations/2] + " Third quartile time for BSUNC : " + arrayIntegers1[3 * iterations / 4] + " Maximum time for BSUNC : " + arrayIntegers1[iterations - 1]);
            System.out.println("Minimum time for BSWN : " + arrayIntegers2[0] + " First quartile time for BSWN : " + arrayIntegers2[iterations/4] + " Median time for BSWN : " + arrayIntegers2[iterations/2] + " Third quartile time for BSWN : " + arrayIntegers2[3 * iterations / 4] + " Maximum time for BSWN : " + arrayIntegers2[iterations - 1]);
            System.out.println("Minimum time for QSGPT : " + arrayIntegers3[0] + " First quartile time for QSGPT : " + arrayIntegers3[iterations/4] + " Median time for QSGPT : " + arrayIntegers3[iterations/2] + " Third quartile time for QSGPT : " + arrayIntegers3[3 * iterations / 4] + " Maximum time for QSGPT : " + arrayIntegers3[iterations - 1]);
            System.out.println("Minimum time for SSGPT : " + arrayIntegers4[0] + " First quartile time for SSGPT : " + arrayIntegers4[iterations/4] + " Median time for SSGPT : " + arrayIntegers4[iterations/2] + " Third quartile time for SSGPT : " + arrayIntegers4[3 * iterations / 4] + " Maximum time for SSGPT : " + arrayIntegers4[iterations - 1]);
            System.out.println();*/
        }

        // After measuring times, export them to CSV
        exportToCSV(arrayIntegers1, "BubbleSortUntilNoChange_Times.csv");
        exportToCSV(arrayIntegers2, "BubbleSortWhileNeeded_Times.csv");
        exportToCSV(arrayIntegers3, "QuickSortGPT_Times.csv");
        exportToCSV(arrayIntegers4, "SelectionSortGPT_Times.csv");

        BubbleSortUntilNoChange<String> BSUNCStrings = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<String> BSWNStrings = new BubbleSortWhileNeeded<>();
        QuickSortGPT<String> QSGPTStrings = new QuickSortGPT<>();
        SelectionSortGPT<String> SSGPTStrings = new SelectionSortGPT<>();

        /*for (String[] array : arrayListStrings) {
            // Iterations
            // Print the formatted array
            System.out.print("Analysis for the array {");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}:");
            for (int i = 0; i < iterations; ++i) {

                startTime = System.nanoTime();
                BSUNCStrings.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                arrayStrings1[i] = totalTime;

                startTime = System.nanoTime();
                BSWNStrings.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                arrayStrings2[i] = totalTime;

                startTime = System.nanoTime();
                QSGPTStrings.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                arrayStrings3[i] = totalTime;

                startTime = System.nanoTime();
                SSGPTStrings.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                arrayStrings4[i] = totalTime;

                System.out.print("Iteration " + (i + 1) + ": Total time for BSUNC: " + arrayStrings1[i]);
                System.out.print(" Total time for BSWN : " + arrayStrings2[i]);
                System.out.print(" Total time for QSGPT : " + arrayStrings3[i]);
                System.out.println(" Total time for SSGPT : " + arrayStrings4[i]);
            }

            Arrays.sort(arrayStrings1);
            Arrays.sort(arrayStrings2);
            Arrays.sort(arrayStrings3);
            Arrays.sort(arrayStrings4);

            *//*long min = Math.min(Math.min(arrayStrings1[iterations/2], arrayStrings2[iterations/2]), Math.min(arrayStrings3[iterations/2], arrayStrings4[iterations/2]));
            if (min == arrayStrings1[iterations/2]) {
                ++countBSUNC;
            }
            else if (min == arrayStrings2[iterations/2]) {
                ++countBSWN;
            }
            else if (min == arrayStrings3[iterations/2]) {
                ++countQSGPT;
            }
            else {
                ++countSSGPT;
            }
            System.out.print("Median time for BSUNC : " + arrayStrings1[iterations/2]);
            System.out.print(" Median time for BSWN : " + arrayStrings2[iterations/2]);
            System.out.print(" Median time for QSGPT : " + arrayStrings3[iterations/2]);
            System.out.println(" Median time for SSGPT : " + arrayStrings4[iterations/2]);
            System.out.println();*//*
        }*/

        /*System.out.print("The fastest algorithm is : ");
        long max_count = Math.max(Math.max(countBSUNC, countBSWN), Math.max(countQSGPT, countSSGPT));
        if (max_count == countBSUNC) {
            System.out.println("BSUNC");
        }
        else if (max_count == countBSWN) {
            System.out.println("BSWN");
        }
        else if (max_count == countQSGPT) {
            System.out.println("QSGPT");
        }
        else {
            System.out.println("SSGPT");
        }*/

    }
}