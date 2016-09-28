package clonegraph;

import common.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Solution {

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
