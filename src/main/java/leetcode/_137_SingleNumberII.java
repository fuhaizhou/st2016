package leetcode;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class _137_SingleNumberII {
    public int singleNumber(int[] nums) {

        // zero i  ii iii
        // 0    1  0  0
        // 0    0  1  0
        int zero = ~0;
        int i = 0;
        int ii = 0;
        int iii = 0;

        for(int j = 0; j < nums.length; j++) {
            int n = nums[j];

            int carry = n & iii; // carry or not? only 1 & 1 should carry
            zero ^= carry; // carry
            iii ^= carry; // after carry  1, 1 --> 0    1, 0 --> 1,   0, 0 --> 0

            carry = n & ii;
            iii ^= carry;
            ii ^= carry;

            carry = n & i;
            ii ^= carry;
            i ^= carry;

            carry = n & zero;
            i ^= carry;
            zero ^= carry;
        }
        return i;
    }
}
