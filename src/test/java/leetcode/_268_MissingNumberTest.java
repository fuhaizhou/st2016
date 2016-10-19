package leetcode;

import leetcode._268_MissingNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _268_MissingNumberTest {

    _268_MissingNumber solution = new _268_MissingNumber();

    @Test
    public void test() {
        int [] nums = {};
        Assert.assertEquals(solution.missingNumber(nums), 0);

        nums = new int []{0,1,2,3,4,5,6,7,8};
        Assert.assertEquals(solution.missingNumber(nums), 9);

        nums = new int []{0,1,2,3,9,5,6,7,8};
        Assert.assertEquals(solution.missingNumber(nums), 4);

        nums = new int []{4,3,0,8,5,1,6,7};
        Assert.assertEquals(solution.missingNumber(nums), 2);
    }
}
