package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSort2Test {
    @Test
    public void testMergeMethod() {
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{2, 4, 6, 8};
        MergeSort2 mergeSort2 = new MergeSort2();
        int[] expected = new int[]{1,2,3,4,5,6,7,8};
        assertArrayEquals(expected, mergeSort2.merge(a, b));
    }

    @Test
    public void testSortMethod() {
        int[] a = new int[]{1, 3, 5, 7, 2, 11, 3};
        MergeSort2 mergeSort2 = new MergeSort2();
        int[] expected = new int[]{1,2,3,3,5,7,11};
        assertArrayEquals(expected, mergeSort2.sort(a));
    }
}
