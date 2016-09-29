package _256_paint_house;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSolution {

    Solution solution = new Solution();

    @Test
    public void test() {
        int [][] costs = {{1,2,3},
            {4,1,6},
            {10,23,1},
            {6,17,66},
            {10,11,13},
            {100,99,98},
            {66,3,1},
            {10,5,32},
            {45,27,333}};
        Assert.assertEquals(solution.minCost(costs), 158);
    }
}
