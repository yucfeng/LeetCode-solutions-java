package graph;

import java.util.*;

// https://leetcode.cn/problems/clone-graph/?show=1
public class CloneGraph {


    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        } else {
            if (visited.containsKey(node)) {
                return visited.get(node);
            } else {
                Node newNode = new Node(node.val);
                visited.put(node, newNode);
                for (Node neighbor : node.neighbors) {
                    newNode.neighbors.add(cloneGraph(neighbor));
                }
                return newNode;
            }
        }
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}


