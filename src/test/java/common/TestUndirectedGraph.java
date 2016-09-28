package common;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUndirectedGraph {

    @Test
    public void testDeserializeAndSerialize() {
        String graphStr = "1,2,5#2,3#3,4,4#4,5,5#5,5";
        UndirectedGraphNode node = UndirectedGraphNode.deSerialize(graphStr);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.neighbors.get(0)
            .neighbors.get(0)
            .neighbors.get(1)
            .label, 4);
        Assert.assertEquals(node.neighbors.get(0)
            .neighbors.get(0)
            .neighbors.get(1)
            .neighbors.get(1)
            .neighbors.get(0)
            .label, 5);

        String serializedGraph = UndirectedGraphNode.serialize(node);
        Assert.assertEquals(graphStr, serializedGraph);
    }
}
