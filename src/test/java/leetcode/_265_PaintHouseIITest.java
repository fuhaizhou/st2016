package leetcode;

import common.ArrayUtils;
import leetcode._265_PaintHouseII;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _265_PaintHouseIITest {

    _265_PaintHouseII solution = new _265_PaintHouseII();

    @Test
    public void test() {
        int [][] costs = {{10,29,19},{1,20,22},{99,387,22},{455,4,3},{1222,45,3455}};
        int min = solution.minCostII(costs);
        Assert.assertEquals(min, 177);

        String str = "[[1,2,3,4,5,6,7,8,9],[34,65,3443,56,2323,667,335,676,23]]";
        costs = ArrayUtils.toIntArray(str);
        min = solution.minCostII(costs);
        Assert.assertEquals(min, 24);
    }
}
