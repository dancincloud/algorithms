package com.algs.graph;

import java.util.*;

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

public class Clone_Graph_2 {
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        //node -> nodes
        List<Node> nodes = getNodes(node);

        //copy nodes
        Map<Node, Node> map = new HashMap<>();
        for(Node n : nodes){
            map.put(n, new Node(n.val));
        }

        //copy neighbors
        for(Node n : nodes){
            Node newNode = map.get(n);
            for(Node neighbor : n.neighbors){
                Node newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return map.get(node);
    }

    private List<Node> getNodes(Node node){
        Set<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(node);
        set.add(node);

        while(!q.isEmpty()){
            int sz = q.size();

            for(int i = 0; i < sz; i++){
                Node n = q.poll();
                for(Node neighbor : n.neighbors){
                    if(!set.contains(neighbor)){
//                        node: q.offer(neighbor);
                        q.offer(neighbor);
                        set.add(neighbor);
                    }
                }

            }
        }

        return new ArrayList<>(set);
    }

}
