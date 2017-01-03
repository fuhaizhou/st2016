package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * <p>
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * <p>
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class _272_ClosestBinarySearchTreeValueII {

    final static double DELTA = 0.000001;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        Stack<TreeNode> predStack = new Stack<>();
        Stack<TreeNode> succStack = new Stack<>();

        TreeNode node = closest(root, target, predStack, succStack);
        List<Integer> results = new ArrayList<>(k);
        results.add((int)node.val);

        TreeNode pred = predecessor(node, predStack);
        TreeNode succ = successor(node, succStack);

        for(int i = 1; i < k; i++) {

            if(pred == null && succ == null)
                break;

            if(pred == null) {
                results.add((int)succ.val);
                succ = successor(succ, succStack);
                continue;
            }

            if(succ == null) {
                results.add((int) pred.val);
                pred = predecessor(pred, predStack);
                continue;
            }

            double predDiff = target - toDouble(pred.val);
            double succDiff = toDouble(succ.val) - target;
            if(predDiff < succDiff) {
                results.add((int) pred.val);
                pred = predecessor(pred, predStack);
            } else {
                results.add((int)succ.val);
                succ = successor(succ, succStack);
            }
        }
        return results;
    }

    TreeNode closest(TreeNode root, double target, Stack<TreeNode> predStack, Stack<TreeNode> succStack) {
        double min = Double.MAX_VALUE;
        TreeNode cur = root;
        while (cur != null) {
            predStack.push(cur);
            succStack.push(cur);

            min = Math.min(min, Math.abs(toDouble(cur.val) - target));
            if (target >= toDouble(cur.val))
                cur = cur.right;
            else
                cur = cur.left;
        }

        while (!predStack.isEmpty()) {
            TreeNode top = predStack.pop();
            succStack.pop();
            double diff = Math.abs(target - toDouble(top.val));
            if (Math.abs(min - diff) < DELTA) {
                return top;
            }
        }

        return null;
    }

    TreeNode predecessor(TreeNode node, Stack<TreeNode> ancestors) {
        // right most of the left node if left is not null
        if (node.left != null) {
            TreeNode rightMost = node.left;
            ancestors.push(node);
            while (rightMost.right != null) {
                ancestors.push(rightMost);
                rightMost = rightMost.right;
            }
            return rightMost;
        }

        // if left is null, first parent who is smaller
        // more generic, first parent, the node is on the right branch of that parent
        TreeNode prevAncestor = node;
        while (!ancestors.isEmpty()) {
            TreeNode ancestor = ancestors.pop();
            if (ancestor.right == prevAncestor)
                return ancestor;
            prevAncestor = ancestor;
        }
        return null;
    }

    TreeNode successor(TreeNode node, Stack<TreeNode> ancestors) {
        // left most of the right node if right is not null
        if (node.right != null) {
            TreeNode leftMost = node.right;
            ancestors.push(node);
            while (leftMost.left != null) {
                ancestors.push(leftMost);
                leftMost = leftMost.left;
            }
            return leftMost;
        }

        // if right is null, first parent who is larger
        // more generic, first parent, the node is on the left branch of that parent
        TreeNode prevAncestor = node;
        while (!ancestors.isEmpty()) {
            TreeNode ancestor = ancestors.pop();
            if (ancestor.left == prevAncestor)
                return ancestor;
            prevAncestor = ancestor;
        }

        return null;
    }

    double toDouble(Object val) {
        return Double.valueOf(String.valueOf(val));
    }
}
