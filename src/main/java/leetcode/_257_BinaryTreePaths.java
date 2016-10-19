package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *    1
 *  /   \
 * 2     3
 * \
 *  5
 *
 * All root-to-leaf paths are:    ["1->2->5", "1->3"]
 */
public class _257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        String rootVal = String.valueOf(root.val);

        if(root.left == null && root.right == null) {
            List<String> paths = new ArrayList<>(1);
            paths.add(rootVal);
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        List<String> rootLeafPaths = new ArrayList<>(leftPaths.size() + rightPaths.size());
        rootLeafPaths.addAll(
            leftPaths.stream()
            .map(path -> rootVal + "->" + path)
            .collect(Collectors.toList())
        );
        rootLeafPaths.addAll(
            rightPaths.stream()
                .map(path -> rootVal + "->" + path)
                .collect(Collectors.toList())
        );
        return rootLeafPaths;
    }
}
