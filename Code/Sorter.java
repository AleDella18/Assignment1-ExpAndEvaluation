package Code;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public interface Sorter<T extends Comparable<T>> {

    void sort(T[] items);

    static void main(String[] args) {

        long countBSUNC = 0;
        long countBSWN = 0;
        long countQSGPT = 0;
        long countSSGPT = 0;

        int iterations = 19;

        long[] arrayIntegers1 = new long[iterations];
        long[] arrayIntegers2 = new long[iterations];
        long[] arrayIntegers3 = new long[iterations];
        long[] arrayIntegers4 = new long[iterations];

        Integer[] testIntegers1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] testIntegers2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Integer[] testIntegers3 = {42};
        Integer[] testIntegers4 = {5, 3};
        Integer[] testIntegers5 = {2, 7, 4, 0, 6, 1, 9, 3, 5, 8};
        Integer[] testIntegers6 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        Integer[] testIntegers7 = {5, 1, 3, 1, 2, 5, 3, 5, 1, 2};
        Integer[] testIntegers8 = new Integer[1000]; // Fill with random values or sequential numbers
        for (int i = 0; i < testIntegers8.length; i++) {
            testIntegers8[i] = (int)(Math.random() * 1000);
        }

        List<Integer[]> arrayListIntegers = new ArrayList<>();
        arrayListIntegers.add(testIntegers1);
        arrayListIntegers.add(testIntegers2);
        arrayListIntegers.add(testIntegers3);
        arrayListIntegers.add(testIntegers4);
        arrayListIntegers.add(testIntegers5);
        arrayListIntegers.add(testIntegers6);
        arrayListIntegers.add(testIntegers7);
        arrayListIntegers.add(testIntegers8);

        long[] arrayStrings1 = new long[iterations];
        long[] arrayStrings2 = new long[iterations];
        long[] arrayStrings3 = new long[iterations];
        long[] arrayStrings4 = new long[iterations];

        String[] testStrings1 = {"apple", "banana", "cherry", "date"};
        String[] testStrings2 = {"zebra", "yak", "xerox", "walrus"};
        String[] testStrings3 = {"apple", "banana", "banana", "cherry", "apple"};
        String[] testStrings4 = {"test", "test", "test", "test"};
        String[] testStrings5 = {"", "banana", "", "cherry", "apple"};
        String[] testStrings6 = {"banana", "apple", "cherry", "date"};
        String[] testStrings7 = {"Apple", "banana", "Cherry", "apple", "Banana"};
        String[] testStrings8 = {"Hello"};

		/*String[] testStrings8 = new String[1000]; // Fill with random values or sequential numbers
		for (int i = 0; i < testStrings8.length; i++) {
			testStrings8[i] = (int)(Math.random() * 1000);
		}*/

        List<String[]> arrayListStrings = new ArrayList<>();
        arrayListStrings.add(testStrings1);
        arrayListStrings.add(testStrings2);
        arrayListStrings.add(testStrings3);
        arrayListStrings.add(testStrings4);
        arrayListStrings.add(testStrings5);
        arrayListStrings.add(testStrings6);
        arrayListStrings.add(testStrings7);
        arrayListStrings.add(testStrings8);

        System.out.println();
        // Accessing and printing each array

        // Instances of the 4 algorithms
        BubbleSortUntilNoChange<Integer> BSUNCIntegers = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<Integer> BSWNIntegers = new BubbleSortWhileNeeded<>();
        QuickSortGPT<Integer> QSGPTIntegers = new QuickSortGPT<>();
        SelectionSortGPT<Integer> SSGPTIntegers = new SelectionSortGPT<>();
        for (Integer[] array : arrayListIntegers) {
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

                long startTime1 = System.nanoTime();
                BSUNCIntegers.sort(array);
                long endTime1 = System.nanoTime();

                // Calculate the total time taken
                long totalTime1 = endTime1 - startTime1;
                arrayIntegers1[i] = totalTime1;

                long startTime2 = System.nanoTime();
                BSWNIntegers.sort(array);
                long endTime2 = System.nanoTime();

                // Calculate the total time taken
                long totalTime2 = endTime2 - startTime2;
                arrayIntegers2[i] = totalTime2;

                long startTime3 = System.nanoTime();
                QSGPTIntegers.sort(array);
                long endTime3 = System.nanoTime();

                // Calculate the total time taken
                long totalTime3 = endTime3 - startTime3;
                arrayIntegers3[i] = totalTime3;

                long startTime4 = System.nanoTime();
                SSGPTIntegers.sort(array);
                long endTime4 = System.nanoTime();

                // Calculate the total time taken
                long totalTime4 = endTime4 - startTime4;
                arrayIntegers4[i] = totalTime4;

                System.out.print("Iteration " + (i + 1) + ": Total time for BSUNC: " + totalTime1);
                System.out.print(" Total time for BSWN : " + totalTime2);
                System.out.print(" Total time for QSGPT : " + totalTime3);
                System.out.println(" Total time for SSGPT : " + totalTime4);
            }

            Arrays.sort(arrayIntegers1);
            Arrays.sort(arrayIntegers2);
            Arrays.sort(arrayIntegers3);
            Arrays.sort(arrayIntegers4);

            long min = Math.min(Math.min(arrayIntegers1[iterations/2], arrayIntegers2[iterations/2]), Math.min(arrayIntegers3[iterations/2], arrayIntegers4[iterations/2]));
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
            }
            System.out.print("Median time for BSUNC : " + arrayIntegers1[iterations/2]);
            System.out.print(" Median time for BSWN : " + arrayIntegers2[iterations/2]);
            System.out.print(" Median time for QSGPT : " + arrayIntegers3[iterations/2]);
            System.out.println(" Median time for SSGPT : " + arrayIntegers4[iterations/2]);
            System.out.println();
        }

        BubbleSortUntilNoChange<String> BSUNCStrings = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<String> BSWNStrings = new BubbleSortWhileNeeded<>();
        QuickSortGPT<String> QSGPTStrings = new QuickSortGPT<>();
        SelectionSortGPT<String> SSGPTStrings = new SelectionSortGPT<>();

        for (String[] array : arrayListStrings) {
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

                long startTime1 = System.nanoTime();
                BSUNCStrings.sort(array);
                long endTime1 = System.nanoTime();

                // Calculate the total time taken
                long totalTime1 = endTime1 - startTime1;
                arrayStrings1[i] = totalTime1;

                long startTime2 = System.nanoTime();
                BSWNStrings.sort(array);
                long endTime2 = System.nanoTime();

                // Calculate the total time taken
                long totalTime2 = endTime2 - startTime2;
                arrayStrings2[i] = totalTime2;

                long startTime3 = System.nanoTime();
                QSGPTStrings.sort(array);
                long endTime3 = System.nanoTime();

                // Calculate the total time taken
                long totalTime3 = endTime3 - startTime3;
                arrayStrings3[i] = totalTime3;

                long startTime4 = System.nanoTime();
                SSGPTStrings.sort(array);
                long endTime4 = System.nanoTime();

                // Calculate the total time taken
                long totalTime4 = endTime4 - startTime4;
                arrayStrings4[i] = totalTime4;

                System.out.print("Iteration " + (i + 1) + ": Total time for BSUNC: " + totalTime1);
                System.out.print(" Total time for BSWN : " + totalTime2);
                System.out.print(" Total time for QSGPT : " + totalTime3);
                System.out.println(" Total time for SSGPT : " + totalTime4);
            }

            Arrays.sort(arrayStrings1);
            Arrays.sort(arrayStrings2);
            Arrays.sort(arrayStrings3);
            Arrays.sort(arrayStrings4);

            long min = Math.min(Math.min(arrayStrings1[iterations/2], arrayStrings2[iterations/2]), Math.min(arrayStrings3[iterations/2], arrayStrings4[iterations/2]));
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
            System.out.println();
        }

        System.out.print("The fastest algorithm is : ");
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
        }

    }
}