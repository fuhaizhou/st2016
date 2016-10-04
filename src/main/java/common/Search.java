package common;

public class Search {

    public static int binarySearch(int [] array, int target) {
        if(array.length == 0)
            return -1;

        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(array[mid] == target)
                return mid;
            if(array[mid] > target)
                end = mid - 1;
            else if(array[mid] < target)
                start = mid + 1;
        }
        return -1;
    }

    public static int binarySearchLastSmaller(int [] array, int target) {
        if(array.length == 0)
            return -1;

        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(array[mid] >= target)
                end = mid - 1;
            else if(array[mid] < target)
                start = mid + 1;
        }
        return end;
    }

    public static int binarySearchFirstLarger(int [] array, int target) {
        if(array.length == 0)
            return 0;

        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(array[mid] > target)
                end = mid - 1;
            else if(array[mid] <= target)
                start = mid + 1;
        }
        return start;
    }
}
