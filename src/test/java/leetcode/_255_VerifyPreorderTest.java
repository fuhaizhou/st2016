package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _255_VerifyPreorderTest {
    _255_VerifyPreorder solution = new _255_VerifyPreorder();

    @Test
    public void test() {
        int [] arr = {1, 2};
        Assert.assertTrue(solution.verifyPreorder(arr));
    }
}
