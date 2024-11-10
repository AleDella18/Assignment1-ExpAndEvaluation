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

        // Number of iterations, iterations % 4 == 1
        int iterations = 63;
        int warmUps = 10;
        int relevantIterations = iterations - warmUps;

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
        String filePath3 = "/home/stipe/Experimentation & Evaluation/Assignment1-ExpAndEvaluation/words_directory/words_100000.txt";
        String[] testStringsLargeArray = ReadWordsToArray.function(filePath3);
        String[] new_testStringsLargeArray = Arrays.copyOfRange(testStringsLargeArray, 0, 11000);

        List<String[]> stringTests = new ArrayList<>();
        stringTests.add(testStringsSmallArray);                             // Test 0: Small size / Random ordered
        Arrays.sort(testStringsSmallArray);                                 //
        stringTests.add(testStringsSmallArray);                             // Test 1: Small size / Already sorted
        Arrays.sort(testStringsSmallArray, Collections.reverseOrder());     //
        stringTests.add(testStringsSmallArray);                             // Test 2: Small size / Reverse sorted

        stringTests.add(testStringsMediumArray);                            // Test 3: Medium size / Random ordered
        Arrays.sort(testStringsMediumArray);                                //
        stringTests.add(testStringsMediumArray);                            // Test 4: Medium size / Already sorted
        Arrays.sort(testStringsMediumArray, Collections.reverseOrder());    //
        stringTests.add(testStringsMediumArray);                            // Test 5: Medium size / Reverse sorted

        stringTests.add(new_testStringsLargeArray);                         // Test 6: Large size / Random ordered
        Arrays.sort(new_testStringsLargeArray);                             //
        stringTests.add(new_testStringsLargeArray);                         // Test 7: Large size / Already sorted
        Arrays.sort(new_testStringsLargeArray, Collections.reverseOrder()); //
        stringTests.add(new_testStringsLargeArray);                         // Test 8: Large size / Reverse sorted

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

            long[] new_executionTimesBSUNC = Arrays.copyOfRange(executionTimesBSUNC, 10, executionTimesBSUNC.length);
            long[] new_executionTimesBSWN = Arrays.copyOfRange(executionTimesBSWN, 10, executionTimesBSWN.length);
            long[] new_executionTimesQSGPT = Arrays.copyOfRange(executionTimesQSGPT, 10, executionTimesQSGPT.length);
            long[] new_executionTimesSSGPT = Arrays.copyOfRange(executionTimesSSGPT, 10, executionTimesSSGPT.length);

            Arrays.sort(new_executionTimesBSUNC);
            Arrays.sort(new_executionTimesBSWN);
            Arrays.sort(new_executionTimesQSGPT);
            Arrays.sort(new_executionTimesSSGPT);

            exportToCSV(new_executionTimesBSUNC, "BubbleSortUntilNoChange_Integer: " + k + ".csv");
            exportToCSV(new_executionTimesBSWN, "BubbleSortWhileNeeded_Integer: " + k + ".csv");
            exportToCSV(new_executionTimesQSGPT, "QuickSortGPT_Integer: " + k + ".csv");
            exportToCSV(new_executionTimesSSGPT, "SelectionSortGPT_Integer: " + k + ".csv");

            ++k;

            System.out.println("Minimum time for BSUNC : " + new_executionTimesBSUNC[0] + " First quartile time for BSUNC : " + new_executionTimesBSUNC[relevantIterations/4] + " Median time for BSUNC : " + new_executionTimesBSUNC[relevantIterations/2] + " Third quartile time for BSUNC : " + new_executionTimesBSUNC[3 * relevantIterations / 4] + " Maximum time for BSUNC : " + new_executionTimesBSUNC[relevantIterations - 1]);
            System.out.println("Minimum time for BSWN : " + new_executionTimesBSWN[0] + " First quartile time for BSWN : " + new_executionTimesBSWN[relevantIterations/4] + " Median time for BSWN : " + new_executionTimesBSWN[relevantIterations/2] + " Third quartile time for BSWN : " + new_executionTimesBSWN[3 * relevantIterations / 4] + " Maximum time for BSWN : " + new_executionTimesBSWN[relevantIterations - 1]);
            System.out.println("Minimum time for QSGPT : " + new_executionTimesQSGPT[0] + " First quartile time for QSGPT : " + new_executionTimesQSGPT[relevantIterations/4] + " Median time for QSGPT : " + new_executionTimesQSGPT[relevantIterations/2] + " Third quartile time for QSGPT : " + new_executionTimesQSGPT[3 * relevantIterations / 4] + " Maximum time for QSGPT : " + new_executionTimesQSGPT[relevantIterations - 1]);
            System.out.println("Minimum time for SSGPT : " + new_executionTimesSSGPT[0] + " First quartile time for SSGPT : " + new_executionTimesSSGPT[relevantIterations/4] + " Median time for SSGPT : " + new_executionTimesSSGPT[relevantIterations/2] + " Third quartile time for SSGPT : " + new_executionTimesSSGPT[3 * relevantIterations / 4] + " Maximum time for SSGPT : " + new_executionTimesSSGPT[relevantIterations - 1]);
            System.out.println();
        }


        // Instances of the 4 algorithms for Strings
        BubbleSortUntilNoChange<String> BSUNCStrings = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<String> BSWNStrings = new BubbleSortWhileNeeded<>();
        QuickSortGPT<String> QSGPTStrings = new QuickSortGPT<>();
        SelectionSortGPT<String> SSGPTStrings = new SelectionSortGPT<>();

        k = 0;
        for (String[] array : stringTests) {
            System.out.println("Analysis for String Test " + k + ":");
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

            long[] new_executionTimesBSUNC = Arrays.copyOfRange(executionTimesBSUNC, 10, executionTimesBSUNC.length);
            long[] new_executionTimesBSWN = Arrays.copyOfRange(executionTimesBSWN, 10, executionTimesBSWN.length);
            long[] new_executionTimesQSGPT = Arrays.copyOfRange(executionTimesQSGPT, 10, executionTimesQSGPT.length);
            long[] new_executionTimesSSGPT = Arrays.copyOfRange(executionTimesSSGPT, 10, executionTimesSSGPT.length);

            Arrays.sort(new_executionTimesBSUNC);
            Arrays.sort(new_executionTimesBSWN);
            Arrays.sort(new_executionTimesQSGPT);
            Arrays.sort(new_executionTimesSSGPT);

            exportToCSV(new_executionTimesBSUNC, "BubbleSortUntilNoChange_String: " + k + ".csv");
            exportToCSV(new_executionTimesBSWN, "BubbleSortWhileNeeded_String: " + k + ".csv");
            exportToCSV(new_executionTimesQSGPT, "QuickSortGPT_String: " + k + ".csv");
            exportToCSV(new_executionTimesSSGPT, "SelectionSortGPT_String: " + k + ".csv");

            ++k;

            System.out.println("Minimum time for BSUNC : " + new_executionTimesBSUNC[0] + " First quartile time for BSUNC : " + new_executionTimesBSUNC[relevantIterations/4] + " Median time for BSUNC : " + new_executionTimesBSUNC[relevantIterations/2] + " Third quartile time for BSUNC : " + new_executionTimesBSUNC[3 * relevantIterations / 4] + " Maximum time for BSUNC : " + new_executionTimesBSUNC[relevantIterations - 1]);
            System.out.println("Minimum time for BSWN : " + new_executionTimesBSWN[0] + " First quartile time for BSWN : " + new_executionTimesBSWN[relevantIterations/4] + " Median time for BSWN : " + new_executionTimesBSWN[relevantIterations/2] + " Third quartile time for BSWN : " + new_executionTimesBSWN[3 * relevantIterations / 4] + " Maximum time for BSWN : " + new_executionTimesBSWN[relevantIterations - 1]);
            System.out.println("Minimum time for QSGPT : " + new_executionTimesQSGPT[0] + " First quartile time for QSGPT : " + new_executionTimesQSGPT[relevantIterations/4] + " Median time for QSGPT : " + new_executionTimesQSGPT[relevantIterations/2] + " Third quartile time for QSGPT : " + new_executionTimesQSGPT[3 * relevantIterations / 4] + " Maximum time for QSGPT : " + new_executionTimesQSGPT[relevantIterations - 1]);
            System.out.println("Minimum time for SSGPT : " + new_executionTimesSSGPT[0] + " First quartile time for SSGPT : " + new_executionTimesSSGPT[relevantIterations/4] + " Median time for SSGPT : " + new_executionTimesSSGPT[relevantIterations/2] + " Third quartile time for SSGPT : " + new_executionTimesSSGPT[3 * relevantIterations / 4] + " Maximum time for SSGPT : " + new_executionTimesSSGPT[relevantIterations - 1]);
            System.out.println();
        }
    }
}
