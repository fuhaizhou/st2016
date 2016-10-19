package leetcode;

import leetcode._264_UglyNumberII;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _264_UglyNumberIITest {
    _264_UglyNumberII solution = new _264_UglyNumberII();

    @Test
    public void test() {
        int n = solution.nthUglyNumber(1);
        Assert.assertEquals(n, 1);
        n = solution.nthUglyNumber(2);
        Assert.assertEquals(n, 2);
        n = solution.nthUglyNumber(3);
        Assert.assertEquals(n, 3);
        n = solution.nthUglyNumber(4);
        Assert.assertEquals(n, 4);
        n = solution.nthUglyNumber(5);
        Assert.assertEquals(n, 5);
        n = solution.nthUglyNumber(6);
        Assert.assertEquals(n, 6);
        n = solution.nthUglyNumber(7);
        Assert.assertEquals(n, 8);
        n = solution.nthUglyNumber(8);
        Assert.assertEquals(n, 9);
        n = solution.nthUglyNumber(9);
        Assert.assertEquals(n, 10);
        n = solution.nthUglyNumber(10);
        Assert.assertEquals(n, 12);
        n = solution.nthUglyNumber(1000);
        Assert.assertEquals(n, 51200000);

        n = solution.nthUglyNumber(1501);
        Assert.assertEquals(n, 860934420);
    }
}
