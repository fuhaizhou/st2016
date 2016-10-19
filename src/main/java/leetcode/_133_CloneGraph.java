package leetcode;

import common.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * OJ's undirected graph serialization:
 *   Nodes are labeled uniquely.
 *   We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 *   As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *   The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *   First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 *   Second node is labeled as 1. Connect node 1 to node 2.
 *   Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 *   Visually, the graph looks like the following:
 *       1
 *      / \
 *    /    \
 *   0 --- 2
 *        / \
 *        \_/
 */
public class _133_CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        UndirectedGraphNode clonedRoot = new UndirectedGraphNode(node.label);

        Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<>();
        cloneMap.put(node, clonedRoot);

        while(!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            UndirectedGraphNode clonedCurNode = cloneMap.get(curNode);

            curNode.neighbors.stream()
                .forEach(neighbor -> {
                    UndirectedGraphNode newNeighbor = cloneMap.get(neighbor);
                    if(newNeighbor == null) {
                        newNeighbor = new UndirectedGraphNode(neighbor.label);
                        cloneMap.put(neighbor, newNeighbor);
                        queue.offer(neighbor);
                    }
                    clonedCurNode.neighbors.add(newNeighbor);
                });
        }
        return clonedRoot;
    }
}
