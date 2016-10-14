package _261_graph_valid_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 *
 * For example:
 *   Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *   Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * Note: you can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 0)
            return true;

        if(edges.length != n - 1)
            return false;

        if(edges.length == 0 && n == 1)
            return true;

        Map<Integer, Set<Integer>> map = convert(edges);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int root = edges[0][0];
        queue.offer(root);
        visited.add(root);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            Set<Integer> neighbors = map.get(node);
            for(int neighbor : neighbors) {
                map.get(neighbor).remove(node);
                if(visited.contains(neighbor))
                    return false;
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return visited.size() == n;
    }

    Map<Integer, Set<Integer>> convert(int [][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>(edges.length);
        for(int [] edge : edges) {
            Set<Integer> neighbors = map.get(edge[0]);
            if(neighbors == null) {
                neighbors = new HashSet<>();
                map.put(edge[0], neighbors);
            }
            neighbors.add(edge[1]);

            neighbors = map.get(edge[1]);
            if(neighbors == null) {
                neighbors = new HashSet<>();
                map.put(edge[1], neighbors);
            }
            neighbors.add(edge[0]);
        }
        return map;
    }
}
