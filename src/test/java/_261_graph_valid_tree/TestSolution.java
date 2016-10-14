package _261_graph_valid_tree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test() {
        int [][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        Assert.assertTrue(solution.validTree(5, edges));

        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        Assert.assertFalse(solution.validTree(5, edges));
    }
}
