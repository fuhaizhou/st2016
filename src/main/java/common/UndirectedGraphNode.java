package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    public static UndirectedGraphNode deSerialize(String graph) {
        String [] strs = graph.split("#");
        UndirectedGraphNode root = null;
        Map<String, UndirectedGraphNode> nodeMap = new HashMap<>(strs.length);
        for(String str : strs) {
            String [] nodes = str.split(",");
            String id = nodes[0];

            UndirectedGraphNode node = nodeMap.get(id);
            if(node == null) {
                node = new UndirectedGraphNode(Integer.parseInt(id));
                nodeMap.put(id, node);
            }
            if(nodeMap.size() == 1)
                root = node;
            for(int i = 1; i < nodes.length; i++) {
                String neighborId = nodes[i];
                UndirectedGraphNode neighbor = nodeMap.get(neighborId);
                if(neighbor == null) {
                    neighbor = new UndirectedGraphNode(Integer.parseInt(neighborId));
                    nodeMap.put(neighborId, neighbor);
                }
                node.neighbors.add(neighbor);
            }
        }
        return root;
    }

    public static String serialize(UndirectedGraphNode root) {
        Set<UndirectedGraphNode> visited = new HashSet<>();
        return serialize(root, visited);
    }

    static String serialize(UndirectedGraphNode root, Set<UndirectedGraphNode> visited) {
        visited.add(root);
        String str = String.valueOf(root.label);
        String neighborStr = root.neighbors.stream()
            .map(neighbor -> String.valueOf(neighbor.label))
            .collect(Collectors.joining(","));
        if(!neighborStr.isEmpty()) {
            str += ",";
            str += neighborStr;
        }

        String recursiveStr = root.neighbors.stream()
            .distinct()
            .filter(neighbor -> !visited.contains(neighbor))
            .map(neighbor -> serialize(neighbor, visited))
            .collect(Collectors.joining("#"));

        if(!recursiveStr.isEmpty()) {
            str += "#";
            str += recursiveStr;
        }

        return str;
    }
}