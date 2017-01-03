package leetcode;

import common.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _272_ClosestBinarySearchTreeValueIITest {

    _272_ClosestBinarySearchTreeValueII solution = new _272_ClosestBinarySearchTreeValueII();

    @Test
    public void test() {
        String treeStr = "3,1,4,0";
        TreeNode root = TreeNode.deSerialize(treeStr);

        List<Integer> results = solution.closestKValues(root, 2.2, 2);
        Assert.assertNotNull(results);

        treeStr = "2,1";
        root = TreeNode.deSerialize(treeStr);
        results = solution.closestKValues(root, 4.142857, 2);
        Assert.assertNotNull(results);

        treeStr = "41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23";
        root = TreeNode.deSerialize(treeStr);
        results = solution.closestKValues(root, 5.142857, 45);
        Assert.assertNotNull(results);
    }
}
