package _137_single_number_ii;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test() {
        int [] nums = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10};
        Assert.assertEquals(solution.singleNumber(nums), 10);

        nums = new int[]{2,2,3,2};
        Assert.assertEquals(solution.singleNumber(nums), 3);
    }
}
