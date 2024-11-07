package Code;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public interface Sorter<T extends Comparable<T>> {
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

    /*
    Main function for running the experiment
     */
    static void main(String[] args) {

        // Number of iterations
        int iterations = 41;

        // Arrays of execution times for the Integer tests
        long[] executionTimesBSUNC = new long[iterations];
        long[] executionTimesBSWN = new long[iterations];
        long[] executionTimesQSGPT = new long[iterations];
        long[] executionTimesSSGPT = new long[iterations];

        // Sizes
        int smallSize = 100;
        int mediumSize = 10000;
        int largeSize = 12000;
        Integer[] integerSizes = {smallSize, mediumSize, largeSize};

        // Creation of the list of tests for type Integer
        List<Integer[]> integerTests = new ArrayList<>();
        for (int size : integerSizes) {
            Integer[] testSorted = new Integer[size];
            // Test sorted
            for (int i = 0; i < size; ++i) {
                testSorted[i] = i;
            }
            integerTests.add(testSorted);
            Integer[] testReverseSorted = new Integer[size];
            for (int i = 0; i < size; ++i) {
                testReverseSorted[i] = size - 1 - i;
            }
            integerTests.add(testReverseSorted);
            Integer[] testRandomOrder = new Integer[size];
            for (int i = 0; i < size; ++i) {
                testRandomOrder[i] = (int) (Math.random() * size);
            }
            integerTests.add(testRandomOrder);
        }


        // Creation of the tests for type String
        String filePath1 = "/home/stipe/Experimentation & Evaluation/Assignment1-ExpAndEvaluation/words_directory/words_100.txt";
        String[] testStringsSmallArray = ReadWordsToArray.function(filePath1);
        String filePath2 = "/home/stipe/Experimentation & Evaluation/Assignment1-ExpAndEvaluation/words_directory/words_10000.txt";
        String[] testStringsMediumArray = ReadWordsToArray.function(filePath2);
        //String filePath3 = "/home/stipe/Experimentation & Evaluation/Assignment1-ExpAndEvaluation/words_directory/words_100000.txt";
        //String[] testStringsLargeArray = ReadWordsToArray.function(filePath3);

        List<String[]> stringTests = new ArrayList<>();
        stringTests.add(testStringsSmallArray); // First add the random ordered
        Arrays.sort(testStringsSmallArray);
        stringTests.add(testStringsSmallArray); // Add the sorted one
        Arrays.sort(testStringsSmallArray, Collections.reverseOrder());
        stringTests.add(testStringsSmallArray); // Add the reverse sorted one

        stringTests.add(testStringsMediumArray);
        Arrays.sort(testStringsMediumArray);
        stringTests.add(testStringsMediumArray);
        Arrays.sort(testStringsMediumArray, Collections.reverseOrder());
        stringTests.add(testStringsMediumArray);

        /*stringTests.add(testStringsLargeArray);
        Arrays.sort(testStringsLargeArray);
        stringTests.add(testStringsLargeArray);
        Arrays.sort(testStringsLargeArray, Collections.reverseOrder());
        stringTests.add(testStringsLargeArray);*/

        // Instances of the 4 algorithms for integers
        BubbleSortUntilNoChange<Integer> BSUNCIntegers = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<Integer> BSWNIntegers = new BubbleSortWhileNeeded<>();
        QuickSortGPT<Integer> QSGPTIntegers = new QuickSortGPT<>();
        SelectionSortGPT<Integer> SSGPTIntegers = new SelectionSortGPT<>();

        long startTime;
        long endTime;
        long totalTime;

        int k = 0;
        for (Integer[] array : integerTests) {
            for (int i = 0; i < iterations; ++i) {

                startTime = System.nanoTime();
                BSUNCIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesBSUNC[i] = totalTime;

                startTime = System.nanoTime();
                BSWNIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesBSWN[i] = totalTime;

                startTime = System.nanoTime();
                QSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesQSGPT[i] = totalTime;

                startTime = System.nanoTime();
                SSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesSSGPT[i] = totalTime;
            }

            Arrays.sort(executionTimesBSUNC);
            Arrays.sort(executionTimesBSWN);
            Arrays.sort(executionTimesQSGPT);
            Arrays.sort(executionTimesSSGPT);

            exportToCSV(executionTimesBSUNC, "BubbleSortUntilNoChange_Integer: " + k + ".csv");
            exportToCSV(executionTimesBSWN, "BubbleSortWhileNeeded_Integer: " + k + ".csv");
            exportToCSV(executionTimesQSGPT, "QuickSortGPT_Integer: " + k + ".csv");
            exportToCSV(executionTimesSSGPT, "SelectionSortGPT_Integer: " + k + ".csv");

            ++k;
        }


        // Instances of the 4 algorithms for Strings
        BubbleSortUntilNoChange<String> BSUNCStrings = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<String> BSWNStrings = new BubbleSortWhileNeeded<>();
        QuickSortGPT<String> QSGPTStrings = new QuickSortGPT<>();
        SelectionSortGPT<String> SSGPTStrings = new SelectionSortGPT<>();

        k = 0;
        for (String[] array : stringTests) {
            for (int i = 0; i < iterations; ++i) {

                startTime = System.nanoTime();
                BSUNCStrings.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesBSUNC[i] = totalTime;

                startTime = System.nanoTime();
                BSWNStrings.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesBSWN[i] = totalTime;

                startTime = System.nanoTime();
                QSGPTStrings.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesQSGPT[i] = totalTime;

                startTime = System.nanoTime();
                SSGPTStrings.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesSSGPT[i] = totalTime;
            }

            Arrays.sort(executionTimesBSUNC);
            Arrays.sort(executionTimesBSWN);
            Arrays.sort(executionTimesQSGPT);
            Arrays.sort(executionTimesSSGPT);

            exportToCSV(executionTimesBSUNC, "BubbleSortUntilNoChange_String: " + k + ".csv");
            exportToCSV(executionTimesBSWN, "BubbleSortWhileNeeded_String: " + k + ".csv");
            exportToCSV(executionTimesQSGPT, "QuickSortGPT_String: " + k + ".csv");
            exportToCSV(executionTimesSSGPT, "SelectionSortGPT_String: " + k + ".csv");

            ++k;
        }
    }
}
