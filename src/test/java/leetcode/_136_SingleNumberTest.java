package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _136_SingleNumberTest {
    _136_SingleNumber solution = new _136_SingleNumber();

    @Test
    public void test() {
        int [] nums = {};
        Assert.assertEquals(solution.singleNumber(nums), 0);
        nums = new int[] {1};
        Assert.assertEquals(solution.singleNumber(nums), 1);
        nums = new int[] {1,1,2,2,3,3,4,4,5,5,6,6,8};
        Assert.assertEquals(solution.singleNumber(nums), 8);
        nums = new int[] {-92039, -10, -100, -78, 99, 3, -10, -78, 3, 99, -100, 0, -92039};
        Assert.assertEquals(solution.singleNumber(nums), 0);
    }
}
