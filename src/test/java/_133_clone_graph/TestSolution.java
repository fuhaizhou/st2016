package _133_clone_graph;

import common.UndirectedGraphNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSolution {

    Solution solution = new Solution();

    @Test
    public void test() {
        String graphStr = "1,2,5#2,3#3,4,4#4,5,5#5,5";
        UndirectedGraphNode node = UndirectedGraphNode.deSerialize(graphStr);
        UndirectedGraphNode colonedNode = solution.cloneGraph(node);
        String clonedGraphStr = UndirectedGraphNode.serialize(colonedNode);
        Assert.assertEquals(clonedGraphStr, graphStr);
    }
}
