package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _261_GraphValidTreeTest {
    _261_GraphValidTree solution = new _261_GraphValidTree();

    @Test
    public void test() {
        int [][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        Assert.assertTrue(solution.validTree(5, edges));

        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        Assert.assertFalse(solution.validTree(5, edges));
    }
}
