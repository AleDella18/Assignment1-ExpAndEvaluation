package Code;

public final class BubbleSortWhileNeeded<T extends Comparable<T>> implements Sorter<T> {

    public void sort(final T[] items) {
        int n = items.length;

        do {
            int maxIndex = 0;
            for (int i = 1; i < n; i++) {
                if (items[i - 1].compareTo(items[i]) > 0) {
                    final T item = items[i - 1];
                    items[i - 1] = items[i];
                    items[i] = item;
                    maxIndex = i;
                }
                /*System.out.print("Iteration: " + i + ", maxIndex = " + maxIndex);
                System.out.print(" Resulting array {");
                for (int j = 0; j < items.length; j++) {
                    System.out.print(items[j]);
                    if (j < items.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("}");*/
            }
            n = maxIndex;
            // System.out.println("n = " + n);
        } while (n > 0);

    }
    /*public static void main(String[] args) {
        Integer[] A = {0, 1, -1, 2};
        Integer[] B = {2, 1, 0, -1};

        BubbleSortWhileNeeded<Integer> b = new BubbleSortWhileNeeded<>();
        b.sort(A);
        System.out.println();
        b.sort(B);
    }*/

}
