package Code;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.*;
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

    static void main(String[] args) {

        int iterations = 41;

        long[] executionTimesSmallArrays1 = new long[iterations];
        long[] executionTimesSmallArrays2 = new long[iterations];
        long[] executionTimesSmallArrays3 = new long[iterations];
        long[] executionTimesSmallArrays4 = new long[iterations];

        long[] executionTimesMediumArrays1 = new long[iterations];
        long[] executionTimesMediumArrays2 = new long[iterations];
        long[] executionTimesMediumArrays3 = new long[iterations];
        long[] executionTimesMediumArrays4 = new long[iterations];

        long[] executionTimesLargeArrays1 = new long[iterations];
        long[] executionTimesLargeArrays2 = new long[iterations];
        long[] executionTimesLargeArrays3 = new long[iterations];
        long[] executionTimesLargeArrays4 = new long[iterations];

        int smallSize = 100;
        int mediumSize = 10000;
        int largeSize = 12000;

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

        List<Integer[]> arrayListIntegerSmallArraysTests = new ArrayList<>();
        arrayListIntegerSmallArraysTests.add(testIntegersSmallArraySorted);
        arrayListIntegerSmallArraysTests.add(testIntegersSmallArrayReverseSorted);
        arrayListIntegerSmallArraysTests.add(testIntegersSmallArrayRandom);

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

        List<Integer[]> arrayListIntegerMediumArraysTests = new ArrayList<>();
        arrayListIntegerMediumArraysTests.add(testIntegersMediumArraySorted);
        arrayListIntegerMediumArraysTests.add(testIntegersMediumArrayReverseSorted);
        arrayListIntegerMediumArraysTests.add(testIntegersMediumArrayRandom);

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

        List<Integer[]> arrayListIntegerLargeArraysTests = new ArrayList<>();
        arrayListIntegerLargeArraysTests.add(testIntegersLargeArraySorted);
        arrayListIntegerLargeArraysTests.add(testIntegersLargeArrayReverseSorted);
        arrayListIntegerLargeArraysTests.add(testIntegersLargeArrayRandom);

        // Instances of the 4 algorithms
        BubbleSortUntilNoChange<Integer> BSUNCIntegers = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<Integer> BSWNIntegers = new BubbleSortWhileNeeded<>();
        QuickSortGPT<Integer> QSGPTIntegers = new QuickSortGPT<>();
        SelectionSortGPT<Integer> SSGPTIntegers = new SelectionSortGPT<>();

        long startTime;
        long endTime;
        long totalTime;

        for (Integer[] array : arrayListIntegerSmallArraysTests) {
            for (int i = 0; i < iterations; ++i) {

                startTime = System.nanoTime();
                BSUNCIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesSmallArrays1[i] = totalTime;

                startTime = System.nanoTime();
                BSWNIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesSmallArrays2[i] = totalTime;

                startTime = System.nanoTime();
                QSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesSmallArrays3[i] = totalTime;

                startTime = System.nanoTime();
                SSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesSmallArrays4[i] = totalTime;
            }

            Arrays.sort(executionTimesSmallArrays1);
            Arrays.sort(executionTimesSmallArrays2);
            Arrays.sort(executionTimesSmallArrays3);
            Arrays.sort(executionTimesSmallArrays4);
        }

        exportToCSV(executionTimesSmallArrays1, "BubbleSortUntilNoChange_Integer_SmallArray_Times.csv");
        exportToCSV(executionTimesSmallArrays2, "BubbleSortWhileNeeded_Integer_SmallArray_Times.csv");
        exportToCSV(executionTimesSmallArrays3, "QuickSortGPT_Integer_SmallArray_Times.csv");
        exportToCSV(executionTimesSmallArrays4, "SelectionSortGPT_Integer_SmallArray_Times.csv");

        for (Integer[] array : arrayListIntegerMediumArraysTests) {
            for (int i = 0; i < iterations; ++i) {

                startTime = System.nanoTime();
                BSUNCIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesMediumArrays1[i] = totalTime;

                startTime = System.nanoTime();
                BSWNIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesMediumArrays2[i] = totalTime;

                startTime = System.nanoTime();
                QSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesMediumArrays3[i] = totalTime;

                startTime = System.nanoTime();
                SSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesMediumArrays4[i] = totalTime;
            }

            Arrays.sort(executionTimesMediumArrays1);
            Arrays.sort(executionTimesMediumArrays2);
            Arrays.sort(executionTimesMediumArrays3);
            Arrays.sort(executionTimesMediumArrays4);
        }

        exportToCSV(executionTimesMediumArrays1, "BubbleSortUntilNoChange_Integer_MediumArray_Times.csv");
        exportToCSV(executionTimesMediumArrays2, "BubbleSortWhileNeeded_Integer_MediumArray_Times.csv");
        exportToCSV(executionTimesMediumArrays3, "QuickSortGPT_Integer_MediumArray_Times.csv");
        exportToCSV(executionTimesMediumArrays4, "SelectionSortGPT_Integer_MediumArray_Times.csv");

        for (Integer[] array : arrayListIntegerLargeArraysTests) {
            for (int i = 0; i < iterations; ++i) {

                startTime = System.nanoTime();
                BSUNCIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesLargeArrays1[i] = totalTime;

                startTime = System.nanoTime();
                BSWNIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesLargeArrays2[i] = totalTime;

                startTime = System.nanoTime();
                QSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesLargeArrays3[i] = totalTime;

                startTime = System.nanoTime();
                SSGPTIntegers.sort(array);
                endTime = System.nanoTime();

                // Calculate the total time taken
                totalTime = endTime - startTime;
                executionTimesLargeArrays4[i] = totalTime;
            }

            Arrays.sort(executionTimesLargeArrays1);
            Arrays.sort(executionTimesLargeArrays2);
            Arrays.sort(executionTimesLargeArrays3);
            Arrays.sort(executionTimesLargeArrays4);
        }

        exportToCSV(executionTimesLargeArrays1, "BubbleSortUntilNoChange_Integer_LargeArray_Times.csv");
        exportToCSV(executionTimesLargeArrays2, "BubbleSortWhileNeeded_Integer_LargeArray_Times.csv");
        exportToCSV(executionTimesLargeArrays3, "QuickSortGPT_Integer_LargeArray_Times.csv");
        exportToCSV(executionTimesLargeArrays4, "SelectionSortGPT_Integer_LargeArray_Times.csv");

    }
}
