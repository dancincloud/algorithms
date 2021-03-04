package com.algs.graph;

import java.util.*;

// deep copy = clone
public class Clone_Graph {
    public  UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        // code quality
        /*
        1. node -> nodes
        2. copy node
        3. copy edges
         */

        if(node == null) return node;

        //use bfs to traverse the graph and get all the nodes
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        //copy nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode n : nodes){
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        //copy neighbors(edges)
        for(UndirectedGraphNode n : nodes){
            UndirectedGraphNode newNode = mapping.get(n);
            for(UndirectedGraphNode neighbor : n.neighbors){
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }


        return mapping.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        q.offer(node);
        set.add(node);

        while (!q.isEmpty()){
            UndirectedGraphNode n = q.poll();
            for(UndirectedGraphNode neighbor : n.neighbors){
                if(set.contains(neighbor)) continue;
                q.offer(neighbor);
                set.add(neighbor);
            }
        }

        return new ArrayList<>(set);
    }
}
