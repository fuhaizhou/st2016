package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
        Set<Node> zeros = buildTree(words, nodeMap);
        if(zeros == null)
            return "";
        String sort = topologySort(zeros);
        if(sort.length() != nodeMap.size())
            return "";
        return addRestChars(words, nodeMap, sort);
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

    String addRestChars(String [] words, Map<Character, Node> nodeMap, String initStr) {
        sb.setLength(0);
        sb.append(initStr);
        Set<Character> appended = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if(!nodeMap.containsKey(c) && !appended.contains(c)) {
                    sb.append(c);
                    appended.add(c);
                }
            }
        }
        return sb.toString();
    }

    Set<Node> buildTree(String [] words, Map<Character, Node> nodeMap) {
        if(words.length == 0)
            return null;

        Set<Node> zeros = new HashSet<>();
        if(words.length == 1) {
            for(char c : words[0].toCharArray()) {
                if(!nodeMap.containsKey(c)) {
                    Node node = new Node(c);
                    nodeMap.put(c, node);
                    zeros.add(node);
                }
            }
            return zeros;
        }

        for(int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];

            int j = 0;
            while(j < prev.length() && j < cur.length() && prev.charAt(j) == cur.charAt(j))
                j++;
            if(j < prev.length() && j >= cur.length())
                return null;
            if(j < prev.length() && j < cur.length()) {
                char preChar = prev.charAt(j);
                char curChar = cur.charAt(j);
                Node preNode = nodeMap.get(preChar);
                if(preNode == null) {
                    preNode = new Node(preChar);
                    nodeMap.put(preChar, preNode);
                    zeros.add(preNode);
                }
                Node curNode = nodeMap.get(curChar);
                if(curNode == null) {
                    curNode = new Node(curChar);
                    nodeMap.put(curChar, curNode);
                }
                preNode.successors.add(curNode);
                curNode.predecessors.add(preNode);
                zeros.remove(curNode);
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
