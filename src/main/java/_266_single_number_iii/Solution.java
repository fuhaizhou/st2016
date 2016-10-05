package _266_single_number_iii;

/**
 * Given an array of numbers nums, in which
 *   1.  exactly two elements appear only once and
 *   2.  all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 *   The order of the result is not important. So in the above example, [5, 3] is also correct.
 *   Your algorithm should run in linear runtime complexity.
 *   Could you implement it using only constant space complexity?
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int n : nums)
            xor ^= n;

        // TODO: this is hard to understand!!!!!
        int diff = xor & (-xor);
        int x = 0;
        for(int n : nums) {
            if((diff & n) == 0)
                x ^= n;
        }
        return new int []{x, xor ^ x};
    }
}
