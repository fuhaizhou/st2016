package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _259_3SumSmallerTest {
    _259_3SumSmaller solution = new _259_3SumSmaller();

    @Test
    public void test() {
        int [] arr = {-2, 0, 1, 3};

        int count = solution.threeSumSmaller(arr, 2);
        Assert.assertEquals(count, 2);

        arr = new int[]{10,100,-19,18,203,-39,-291,49,29,-383,-119};
        count = solution.threeSumSmaller(arr, 100);
        Assert.assertEquals(count, 131);

        arr = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        count = solution.threeSumSmaller(arr, 36);
        Assert.assertEquals(count, 825);
    }
}
