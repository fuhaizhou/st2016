package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class TreeNode<T> {

    private static final String NULL = "null";

    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T x) {
        val = x;
    }

    public static String serialize(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        List<String> traversal = new ArrayList();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                traversal.add(NULL);
            } else {
                traversal.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        int i = traversal.size() - 1;
        while(i >= 0 && NULL.equals(traversal.get(i)))
            i--;

        return traversal.stream().limit(i + 1).collect(Collectors.joining(","));
    }

    public static TreeNode deSerialize(String treeStr) {
        if(treeStr.isEmpty())
            return null;

        String [] nodesStr = treeStr.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodesStr[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        int i = 1;
        while(!queue.isEmpty() && i < nodesStr.length) {
            TreeNode node = queue.poll();
            String leftStr = nodesStr[i];
            String rightStr = i + 1 < nodesStr.length ? nodesStr[i + 1] : NULL;
            i += 2;
            if(!NULL.equals(leftStr)) {
                TreeNode left = new TreeNode(Integer.valueOf(leftStr));
                node.left = left;
                queue.offer(left);
            }
            if(!NULL.equals(rightStr)) {
                TreeNode right = new TreeNode(Integer.valueOf(rightStr));
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}