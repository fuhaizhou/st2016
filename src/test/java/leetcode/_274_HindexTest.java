package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _274_HindexTest {

    _274_Hindex solution = new _274_Hindex();

    @Test
    public void test() {
        int [] citations = {};
        int h = solution.hIndex(citations);
        Assert.assertEquals(h, 0);

        citations = new int [] {0};
        h = solution.hIndex(citations);
        Assert.assertEquals(h, 0);

        citations = new int [] {1};
        h = solution.hIndex(citations);
        Assert.assertEquals(h, 1);

        citations = new int [] {3, 0, 6, 1, 5};
        h = solution.hIndex(citations);
        Assert.assertEquals(h, 3);
    }
}
