package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 *
 * For example, Given the following words in dictionary,
 *     [ "wrt", "wrf", "er", "ett", "rftt" ]
 *     The correct order is: "wertf".
 *
 * Note:
 *     You may assume all letters are in lowercase. If the order is invalid, return an empty string.
 *     There may be multiple valid order of letters, return any one of them is fine.
 */
public class _269_AlienDictionary {

    static StringBuilder sb = new StringBuilder();

    public String alienOrder(String [] words) {
        Map<Character, Node> nodeMap = new HashMap<>();
        Set<Character> treeNodes = new HashSet<>();
        Set<Node> zeros = buildTree(words, nodeMap, treeNodes);
        if(zeros == null)
            return "";
        String sort = topologySort(zeros);
        if(sort.length() != treeNodes.size())
            return "";
        return sort + nodeMap.keySet().stream()
            .filter(x -> !treeNodes.contains(x))
            .map(x -> "" + x)
            .collect(Collectors.joining(""));
    }

    static class Node {
        Set<Node> predecessors;
        char val;
        Set<Node> successors;

        Node(char c) {
            this.val = c;
            this.successors = new HashSet<>();
            this.predecessors = new HashSet<>();
        }
    }

    Set<Node> buildTree(String [] words, Map<Character, Node> nodeMap, Set<Character> treeNodes) {
        if(words.length == 0)
            return null;

        Set<Node> zeros = new HashSet<>();
        if(words.length == 1) {
            for(char c : words[0].toCharArray()) {
                if(!treeNodes.contains(c)) {
                    treeNodes.add(c);
                    zeros.add(new Node(c));
                }
            }
            return zeros;
        }

        for(int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];

            int j = 0;
            boolean diff = false;
            while(j < cur.length() || j < prev.length()) {
                Node prevNode = null;
                Node curNode = null;
                if(j < prev.length()) {
                    char prevChar = prev.charAt(j);
                    prevNode = nodeMap.get(prevChar);
                    if(prevNode == null) {
                        prevNode = new Node(prevChar);
                        nodeMap.put(prevChar, prevNode);
                    }
                }
                if(j < cur.length()) {
                    char curChar = cur.charAt(j);
                    curNode = nodeMap.get(curChar);
                    if(curNode == null) {
                        curNode = new Node(curChar);
                        nodeMap.put(curChar, curNode);
                    }
                }
                if(!diff && prevNode != null && curNode == null)
                    return null;
                if(!diff && prevNode != null && curNode != null && prev.charAt(j) != cur.charAt(j)) {
                    diff = true;
                    prevNode.successors.add(curNode);
                    curNode.predecessors.add(prevNode);
                    if(prevNode.predecessors.size() == 0)
                        zeros.add(prevNode);
                    zeros.remove(curNode);
                    treeNodes.add(prevNode.val);
                    treeNodes.add(curNode.val);
                }
                j++;
            }
        }
        return zeros;
    }

    String topologySort(Set<Node> zeros) {
        sb.setLength(0);
        Queue<Node> zerosQueue = new LinkedList<>();
        zerosQueue.addAll(zeros);
        while(!zerosQueue.isEmpty()) {
            Node node = zerosQueue.poll();
            sb.append(node.val);
            for(Node successor : node.successors) {
                successor.predecessors.remove(node);
                if(successor.predecessors.size() == 0)
                    zerosQueue.offer(successor);
            }
        }
        return sb.toString();
    }
}
