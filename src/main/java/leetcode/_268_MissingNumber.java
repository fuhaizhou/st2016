package leetcode;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * For example, Given nums = [0, 1, 3] return 2.
 * Note:
 *     Your algorithm should run in linear runtime complexity.
 *     Could you implement it using only constant extra space complexity?
 */
public class _268_MissingNumber {
    public int missingNumber(int[] nums) {

        int missingAt = nums.length;
        int cur = 0;
        while(cur < nums.length) {
            if(cur == nums[cur]) {
                cur++;
            } else if(nums[cur] == nums.length) {
                nums[cur] = -1;
                missingAt = cur;
                cur++;
            } else if(nums[cur] == -1) {
                missingAt = cur;
                cur++;
            } else {
                swap(nums, cur, nums[cur]);
            }
        }
        return missingAt;
    }

    void swap(int [] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
