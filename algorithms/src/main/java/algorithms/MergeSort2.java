package algorithms;

import java.util.Arrays;

import static java.lang.StrictMath.floor;
import static java.lang.System.arraycopy;

public class MergeSort2 {

    public int[] sort(int[] a) {
        return mergeSort(a, a.length);
    }

    /**
     * We split the array into two parts. We sort each of the two parts recursively,
     * then we merge the two sorted arrays into one big array
     * @param a
     * @param n
     * @return
     */
    public int[] mergeSort(int[] a, int n) {
        if(n == 1)
            return a; //This means it is already sorted
        int middle = (int) floor(a.length / 2);
        int[] leftHalf = new int[middle];
        arraycopy(a, 0, leftHalf, 0, middle);

        int[] rightHalf = new int[a.length - middle];
        arraycopy(a, middle, rightHalf, 0, a.length - middle);

        return merge(mergeSort(leftHalf, middle), mergeSort(rightHalf, a.length - middle));

    }

    /**
     * takes two arrays that are both already sorted and merges them together into a big sorted array
     *
     * @param a
     * @param b
     */
    public int[] merge(int[] a, int[] b) {
        if (a.length == 0)
            return b;
        else if (b.length == 0)
            return a;
        if (a[0] < b[0]) {
            return concat(a[0], merge(tail(a), b));
        } else {
            return concat(b[0], merge(a, tail(b)));
        }
    }

    private int[] tail(int[] a) {
        int[] result = new int[a.length - 1];
        arraycopy(a, 1, result, 0, result.length);
        return result;
    }

    public static int[] concat(int head, int[] tail) {
        int[] result = new int[tail.length + 1];
        result[0] = head;
        arraycopy(tail, 0, result, 1, tail.length);
        return result;
    }
}
