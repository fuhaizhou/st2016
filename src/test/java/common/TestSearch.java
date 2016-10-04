package common;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearch {

    @Test
    public void testBinarySearch() {
        int [] arr = {-100, -50, -10, -5, -1, 0, 10, 100, 1000, 10000};
        Assert.assertEquals(Search.binarySearch(arr, 0), 5);
        Assert.assertEquals(Search.binarySearch(arr, 10), 6);
        Assert.assertEquals(Search.binarySearch(arr, -100), 0);
        Assert.assertEquals(Search.binarySearch(arr, 38374), -1);

        arr = new int []{};
        Assert.assertEquals(Search.binarySearch(arr, 0), -1);

        arr = new int []{0};
        Assert.assertEquals(Search.binarySearch(arr, 0), 0);
        Assert.assertEquals(Search.binarySearch(arr, 1), -1);
    }

    @Test
    public void testBinarySearchLastSmaller() {
        int[] arr = {-100, -100, -10, -5, -5, 0, 0, 10, 10, 10, 10, 10, 100, 1000, 10000, 10000};
        Assert.assertEquals(Search.binarySearchLastSmaller(arr, 20), 11);
        Assert.assertEquals(Search.binarySearchLastSmaller(arr, 0), 4);
        Assert.assertEquals(Search.binarySearchLastSmaller(arr, -99), 1);
        Assert.assertEquals(Search.binarySearchLastSmaller(arr, -100), -1);
        Assert.assertEquals(Search.binarySearchLastSmaller(arr, 10001), 15);

        arr = new int []{};
        Assert.assertEquals(Search.binarySearchLastSmaller(arr, 0), -1);

        arr = new int []{0};
        Assert.assertEquals(Search.binarySearchLastSmaller(arr, 0), -1);
    }

    @Test
    public void testBinarySearchFirstLarger() {
        int[] arr = {-100, -100, -10, -5, -5, 0, 0, 10, 10, 10, 10, 10, 100, 1000, 10000, 10000};
        Assert.assertEquals(Search.binarySearchFirstLarger(arr, 20), 12);
        Assert.assertEquals(Search.binarySearchFirstLarger(arr, 0), 7);
        Assert.assertEquals(Search.binarySearchFirstLarger(arr, -99), 2);
        Assert.assertEquals(Search.binarySearchFirstLarger(arr, -100), 2);
        Assert.assertEquals(Search.binarySearchFirstLarger(arr, 10001), 16);

        arr = new int []{};
        Assert.assertEquals(Search.binarySearchFirstLarger(arr, 0), 0);

        arr = new int []{0};
        Assert.assertEquals(Search.binarySearchFirstLarger(arr, 0), 1);
    }
}
