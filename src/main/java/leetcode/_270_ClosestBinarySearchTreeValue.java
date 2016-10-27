package leetcode;

import common.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class _270_ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {

        double rootVal = Double.valueOf(String.valueOf(root.val));
        if((root.left == null && root.right == null) ||
            (root.left == null && target < rootVal) ||
            (root.right == null && target > rootVal))
            return (int)root.val;


        if(target == rootVal)
            return (int)root.val;

        int closest = 0;
        if(target < rootVal) {
            closest = closestValue(root.left, target);
        } else if (target > rootVal) {
            closest = closestValue(root.right, target);
        }
        if(Math.abs(rootVal - target) < Math.abs(target - closest))
            return (int)root.val;
        else
            return closest;
    }
}
