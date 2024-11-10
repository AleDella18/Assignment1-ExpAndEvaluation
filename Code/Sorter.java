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
        int iterations = 60;
        int warmUps = 10;
        int relevantIterations = iterations - warmUps;

        // Arrays of execution times for the tests
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
        Random rand = new Random();

        for (int size : integerSizes) {
            // Test sorted
            Integer[] testSorted = new Integer[size];
            for (int i = 0; i < size; ++i) {
                testSorted[i] = i;
            }
            integerTests.add(testSorted);

            // Test reverse sorted
            Integer[] testReverseSorted = new Integer[size];
            for (int i = 0; i < size; ++i) {
                testReverseSorted[i] = size - 1 - i;
            }
            integerTests.add(testReverseSorted);

            // Test random order
            Integer[] testRandomOrder = new Integer[size];
            for (int i = 0; i < size; ++i) {
                testRandomOrder[i] = rand.nextInt(size);
            }
            integerTests.add(testRandomOrder);
        }

        // Creation of the tests for type String
        String filePath1 = System.getProperty("user.dir") + "/words_directory/words_100.txt";
        String[] testStringsSmallArray = ReadWordsToArray.function(filePath1);

        String filePath2 = System.getProperty("user.dir") + "/words_directory/words_10000.txt";
        String[] testStringsMediumArray = ReadWordsToArray.function(filePath2);

        String filePath3 = System.getProperty("user.dir") + "/words_directory/words_100000.txt";
        String[] testStringsLargeArray = ReadWordsToArray.function(filePath3);

        String[] new_testStringsLargeArray = Arrays.copyOfRange(testStringsLargeArray, 0, 11000);

        List<String[]> stringTests = new ArrayList<>();

        // For small size arrays
        String[] smallRandomOrder = Arrays.copyOf(testStringsSmallArray, testStringsSmallArray.length);
        stringTests.add(smallRandomOrder); // Test 0: Small size / Random ordered

        String[] smallSortedOrder = Arrays.copyOf(testStringsSmallArray, testStringsSmallArray.length);
        Arrays.sort(smallSortedOrder);
        stringTests.add(smallSortedOrder); // Test 1: Small size / Already sorted

        String[] smallReverseSortedOrder = Arrays.copyOf(testStringsSmallArray, testStringsSmallArray.length);
        Arrays.sort(smallReverseSortedOrder, Collections.reverseOrder());
        stringTests.add(smallReverseSortedOrder); // Test 2: Small size / Reverse sorted

        // For medium size arrays
        String[] mediumRandomOrder = Arrays.copyOf(testStringsMediumArray, testStringsMediumArray.length);
        stringTests.add(mediumRandomOrder); // Test 3: Medium size / Random ordered

        String[] mediumSortedOrder = Arrays.copyOf(testStringsMediumArray, testStringsMediumArray.length);
        Arrays.sort(mediumSortedOrder);
        stringTests.add(mediumSortedOrder); // Test 4: Medium size / Already sorted

        String[] mediumReverseSortedOrder = Arrays.copyOf(testStringsMediumArray, testStringsMediumArray.length);
        Arrays.sort(mediumReverseSortedOrder, Collections.reverseOrder());
        stringTests.add(mediumReverseSortedOrder); // Test 5: Medium size / Reverse sorted

        // For large size arrays
        String[] largeRandomOrder = Arrays.copyOf(new_testStringsLargeArray, new_testStringsLargeArray.length);
        stringTests.add(largeRandomOrder); // Test 6: Large size / Random ordered

        String[] largeSortedOrder = Arrays.copyOf(new_testStringsLargeArray, new_testStringsLargeArray.length);
        Arrays.sort(largeSortedOrder);
        stringTests.add(largeSortedOrder); // Test 7: Large size / Already sorted

        String[] largeReverseSortedOrder = Arrays.copyOf(new_testStringsLargeArray, new_testStringsLargeArray.length);
        Arrays.sort(largeReverseSortedOrder, Collections.reverseOrder());
        stringTests.add(largeReverseSortedOrder); // Test 8: Large size / Reverse sorted

        // Instances of the 4 algorithms for integers
        BubbleSortUntilNoChange<Integer> BSUNCIntegers = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<Integer> BSWNIntegers = new BubbleSortWhileNeeded<>();
        QuickSortGPT<Integer> QSGPTIntegers = new QuickSortGPT<>();
        SelectionSortGPT<Integer> SSGPTIntegers = new SelectionSortGPT<>();

        long startTime;
        long endTime;
        long totalTime;

        int k = 0;
        for (Integer[] originalArray : integerTests) {
            System.out.println("Analysis for Integer Test " + k + ":");
            for (int i = 0; i < iterations; ++i) {

                // QuickSortGPT
                Integer[] arrayCopy = Arrays.copyOf(originalArray, originalArray.length);
                startTime = System.nanoTime();
                QSGPTIntegers.sort(arrayCopy);
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                executionTimesQSGPT[i] = totalTime;

                // BubbleSortUntilNoChange
                arrayCopy = Arrays.copyOf(originalArray, originalArray.length);
                startTime = System.nanoTime();
                BSUNCIntegers.sort(arrayCopy);
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                executionTimesBSUNC[i] = totalTime;

                // BubbleSortWhileNeeded
                arrayCopy = Arrays.copyOf(originalArray, originalArray.length);
                startTime = System.nanoTime();
                BSWNIntegers.sort(arrayCopy);
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                executionTimesBSWN[i] = totalTime;

                // SelectionSortGPT
                arrayCopy = Arrays.copyOf(originalArray, originalArray.length);
                startTime = System.nanoTime();
                SSGPTIntegers.sort(arrayCopy);
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                executionTimesSSGPT[i] = totalTime;
            }

            // Exclude warm-up iterations
            long[] new_executionTimesBSUNC = Arrays.copyOfRange(executionTimesBSUNC, warmUps, iterations);
            long[] new_executionTimesBSWN = Arrays.copyOfRange(executionTimesBSWN, warmUps, iterations);
            long[] new_executionTimesQSGPT = Arrays.copyOfRange(executionTimesQSGPT, warmUps, iterations);
            long[] new_executionTimesSSGPT = Arrays.copyOfRange(executionTimesSSGPT, warmUps, iterations);

            Arrays.sort(new_executionTimesBSUNC);
            Arrays.sort(new_executionTimesBSWN);
            Arrays.sort(new_executionTimesQSGPT);
            Arrays.sort(new_executionTimesSSGPT);

            exportToCSV(new_executionTimesBSUNC, "BubbleSortUntilNoChange_Integer_" + k + ".csv");
            exportToCSV(new_executionTimesBSWN, "BubbleSortWhileNeeded_Integer_" + k + ".csv");
            exportToCSV(new_executionTimesQSGPT, "QuickSortGPT_Integer_" + k + ".csv");
            exportToCSV(new_executionTimesSSGPT, "SelectionSortGPT_Integer_" + k + ".csv");

            ++k;

            // Output statistical data
            System.out.println("Minimum time for BSUNC: " + new_executionTimesBSUNC[0]);
            System.out.println("First quartile time for BSUNC: " + new_executionTimesBSUNC[relevantIterations / 4]);
            System.out.println("Median time for BSUNC: " + new_executionTimesBSUNC[relevantIterations / 2]);
            System.out.println("Third quartile time for BSUNC: " + new_executionTimesBSUNC[relevantIterations / 4 * 3]);
            System.out.println("Maximum time for BSUNC: " + new_executionTimesBSUNC[relevantIterations - 1] + "\n");

            System.out.println("Minimum time for BSWN: " + new_executionTimesBSWN[0]);
            System.out.println("First quartile time for BSWN: " + new_executionTimesBSWN[relevantIterations / 4]);
            System.out.println("Median time for BSWN: " + new_executionTimesBSWN[relevantIterations / 2]);
            System.out.println("Third quartile time for BSWN: " + new_executionTimesBSWN[relevantIterations / 4 * 3]);
            System.out.println("Maximum time for BSWN: " + new_executionTimesBSWN[relevantIterations - 1] + "\n");

            System.out.println("Minimum time for QSGPT: " + new_executionTimesQSGPT[0]);
            System.out.println("First quartile time for QSGPT: " + new_executionTimesQSGPT[relevantIterations / 4]);
            System.out.println("Median time for QSGPT: " + new_executionTimesQSGPT[relevantIterations / 2]);
            System.out.println("Third quartile time for QSGPT: " + new_executionTimesQSGPT[relevantIterations / 4 * 3]);
            System.out.println("Maximum time for QSGPT: " + new_executionTimesQSGPT[relevantIterations - 1] + "\n");

            System.out.println("Minimum time for SSGPT: " + new_executionTimesSSGPT[0]);
            System.out.println("First quartile time for SSGPT: " + new_executionTimesSSGPT[relevantIterations / 4]);
            System.out.println("Median time for SSGPT: " + new_executionTimesSSGPT[relevantIterations / 2]);
            System.out.println("Third quartile time for SSGPT: " + new_executionTimesSSGPT[relevantIterations / 4 * 3]);
            System.out.println("Maximum time for SSGPT: " + new_executionTimesSSGPT[relevantIterations - 1] + "\n");
        }

        // Instances of the 4 algorithms for Strings
        BubbleSortUntilNoChange<String> BSUNCStrings = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<String> BSWNStrings = new BubbleSortWhileNeeded<>();
        QuickSortGPT<String> QSGPTStrings = new QuickSortGPT<>();
        SelectionSortGPT<String> SSGPTStrings = new SelectionSortGPT<>();

        k = 0;
        for (String[] originalArray : stringTests) {
            System.out.println("Analysis for String Test " + k + ":");
            for (int i = 0; i < iterations; ++i) {

                // BubbleSortUntilNoChange
                String[] arrayCopy = Arrays.copyOf(originalArray, originalArray.length);
                startTime = System.nanoTime();
                BSUNCStrings.sort(arrayCopy);
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                executionTimesBSUNC[i] = totalTime;

                // BubbleSortWhileNeeded
                arrayCopy = Arrays.copyOf(originalArray, originalArray.length);
                startTime = System.nanoTime();
                BSWNStrings.sort(arrayCopy);
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                executionTimesBSWN[i] = totalTime;

                // QuickSortGPT
                arrayCopy = Arrays.copyOf(originalArray, originalArray.length);
                startTime = System.nanoTime();
                QSGPTStrings.sort(arrayCopy);
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                executionTimesQSGPT[i] = totalTime;

                // SelectionSortGPT
                arrayCopy = Arrays.copyOf(originalArray, originalArray.length);
                startTime = System.nanoTime();
                SSGPTStrings.sort(arrayCopy);
                endTime = System.nanoTime();
                totalTime = endTime - startTime;
                executionTimesSSGPT[i] = totalTime;
            }

            // Exclude warm-up iterations
            long[] new_executionTimesBSUNC = Arrays.copyOfRange(executionTimesBSUNC, warmUps, iterations);
            long[] new_executionTimesBSWN = Arrays.copyOfRange(executionTimesBSWN, warmUps, iterations);
            long[] new_executionTimesQSGPT = Arrays.copyOfRange(executionTimesQSGPT, warmUps, iterations);
            long[] new_executionTimesSSGPT = Arrays.copyOfRange(executionTimesSSGPT, warmUps, iterations);

            Arrays.sort(new_executionTimesBSUNC);
            Arrays.sort(new_executionTimesBSWN);
            Arrays.sort(new_executionTimesQSGPT);
            Arrays.sort(new_executionTimesSSGPT);

            exportToCSV(new_executionTimesBSUNC, "BubbleSortUntilNoChange_String_" + k + ".csv");
            exportToCSV(new_executionTimesBSWN, "BubbleSortWhileNeeded_String_" + k + ".csv");
            exportToCSV(new_executionTimesQSGPT, "QuickSortGPT_String_" + k + ".csv");
            exportToCSV(new_executionTimesSSGPT, "SelectionSortGPT_String_" + k + ".csv");

            ++k;

            // Output statistical data
            System.out.println("Minimum time for BSUNC: " + new_executionTimesBSUNC[0]);
            System.out.println("First quartile time for BSUNC: " + new_executionTimesBSUNC[relevantIterations / 4]);
            System.out.println("Median time for BSUNC: " + new_executionTimesBSUNC[relevantIterations / 2]);
            System.out.println("Third quartile time for BSUNC: " + new_executionTimesBSUNC[relevantIterations / 4 * 3]);
            System.out.println("Maximum time for BSUNC: " + new_executionTimesBSUNC[relevantIterations - 1] + "\n");

            System.out.println("Minimum time for BSWN: " + new_executionTimesBSWN[0]);
            System.out.println("First quartile time for BSWN: " + new_executionTimesBSWN[relevantIterations / 4]);
            System.out.println("Median time for BSWN: " + new_executionTimesBSWN[relevantIterations / 2]);
            System.out.println("Third quartile time for BSWN: " + new_executionTimesBSWN[relevantIterations / 4 * 3]);
            System.out.println("Maximum time for BSWN: " + new_executionTimesBSWN[relevantIterations - 1] + "\n");

            System.out.println("Minimum time for QSGPT: " + new_executionTimesQSGPT[0]);
            System.out.println("First quartile time for QSGPT: " + new_executionTimesQSGPT[relevantIterations / 4]);
            System.out.println("Median time for QSGPT: " + new_executionTimesQSGPT[relevantIterations / 2]);
            System.out.println("Third quartile time for QSGPT: " + new_executionTimesQSGPT[relevantIterations / 4 * 3]);
            System.out.println("Maximum time for QSGPT: " + new_executionTimesQSGPT[relevantIterations - 1] + "\n");

            System.out.println("Minimum time for SSGPT: " + new_executionTimesSSGPT[0]);
            System.out.println("First quartile time for SSGPT: " + new_executionTimesSSGPT[relevantIterations / 4]);
            System.out.println("Median time for SSGPT: " + new_executionTimesSSGPT[relevantIterations / 2]);
            System.out.println("Third quartile time for SSGPT: " + new_executionTimesSSGPT[relevantIterations / 4 * 3]);
            System.out.println("Maximum time for SSGPT: " + new_executionTimesSSGPT[relevantIterations - 1] + "\n");
        }
    }
}
