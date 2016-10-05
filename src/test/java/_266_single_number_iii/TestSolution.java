package _266_single_number_iii;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test() {
        int a = 0b11110000;
        int b = 0b10101010;
        int xor = a ^ b;
        int minus = -xor;
        int diff = xor & minus;
        int [] nums = {1, 2, 1, 3, 2, 5};
        int [] results = solution.singleNumber(nums);
        List<Integer> expected = new ArrayList<>(2);
        expected.add(3);
        expected.add(5);
        Assert.assertTrue(expected.contains(results[0]));
        Assert.assertTrue(expected.contains(results[1]));
    }
}
