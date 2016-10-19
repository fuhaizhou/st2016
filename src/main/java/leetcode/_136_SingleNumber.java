package leetcode;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class _136_SingleNumber {
    public int singleNumber(int [] nums) {
        if(nums.length == 0)
            return 0;
        int x = nums[0];
        for(int i = 1; i < nums.length; i++)
            x ^= nums[i];
        return x;
    }
}
