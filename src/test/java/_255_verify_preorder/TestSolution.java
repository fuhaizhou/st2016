package _255_verify_preorder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test() {
        int [] arr = {1, 2};
        Assert.assertTrue(solution.verifyPreorder(arr));
    }
}
