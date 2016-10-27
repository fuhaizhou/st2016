package leetcode;

import common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _270_ClosestBinarySearchTreeValueTest {
    _270_ClosestBinarySearchTreeValue solution = new _270_ClosestBinarySearchTreeValue();

    @Test
    public void test() {
        String treeStr = "3,1,4,0,null";
        TreeNode root = TreeNode.deSerialize(treeStr);
        int x = solution.closestValue(root, 2.2);
        Assert.assertEquals(x, 3);

        x = solution.closestValue(root, 3.3);
        Assert.assertEquals(x, 3);
    }
}
