package Code;

public final class BubbleSortUntilNoChange<T extends Comparable<T>> implements Sorter<T> {

    public void sort(final T[] items) {
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < items.length - 1; i++) {
                if (items[i].compareTo(items[i + 1]) > 0) {
                    final T item = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = item;
                    changed = true;
                }
                /*System.out.print("Iteration: " + i + ", changed = " + changed);
                System.out.print(" Resulting array {");
                for (int j = 0; j < items.length; j++) {
                    System.out.print(items[j]);
                    if (j < items.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("}");*/
            }
        } while (changed);
    }
    /*public static void main(String[] args) {
        Integer[] A = {0, 1, -1, 2};
        Integer[] B = {2, 1, 0, -1};

        BubbleSortUntilNoChange<Integer> b = new BubbleSortUntilNoChange<>();
        b.sort(A);
        System.out.println();
        b.sort(B);
    }*/

}