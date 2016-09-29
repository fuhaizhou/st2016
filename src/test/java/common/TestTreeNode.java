package common;

import org.testng.Assert;
import org.testng.annotations.Test;

import static common.TreeNode.serialize;

public class TestTreeNode {

    @Test
    public void testSerialize() {
        TreeNode [] nodes = new TreeNode[10];
        for(int i = 0; i < 10; i++)
            nodes[i] = new TreeNode(i);

        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].right = nodes[3];
        nodes[2].left = nodes[4];
        nodes[2].right = nodes[5];
        nodes[3].right = nodes[6];
        nodes[4].right = nodes[7];
        nodes[5].left = nodes[8];
        nodes[5].right = nodes[9];

        String serialized = serialize(nodes[0]);
        Assert.assertEquals(serialized, "0,1,2,null,3,4,5,null,6,null,7,8,9");
    }

    @Test
    public void testDeSerialize() {

        String treeStr = "0,1,2,null,3,4,5,null,6,null,7,8,9";
        TreeNode root = TreeNode.deSerialize(treeStr);
        Assert.assertNotNull(root);
        String serialized = TreeNode.serialize(root);
        Assert.assertEquals(serialized, treeStr);
    }
}
