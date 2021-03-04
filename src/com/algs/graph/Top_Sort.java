package com.algs.graph;

import java.util.*;

public class Top_Sort {
//    Find any topological order for the given graph
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
        ArrayList<DirectedGraphNode> order = new ArrayList<>();

        if(graph == null || graph.size() == 0) return order;

        // 1. count indegree 入度（有多少条边指向点）
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);

        // 2. topological sorting - bfs
        ArrayList<DirectedGraphNode> startNodes = getStartNodes(indegree, graph);

        // 3. bfs
        order = bfs(indegree, startNodes);
        if(order.size() == graph.size()) return  order;

        return null;
    }

    private Map<DirectedGraphNode, Integer>getIndegree(ArrayList<DirectedGraphNode> graph){
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();

        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        return indegree;
    }

    private ArrayList<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode, Integer> indegree, ArrayList<DirectedGraphNode> graph){
        ArrayList<DirectedGraphNode> startNodes = new ArrayList<>();
        for(DirectedGraphNode node : graph){
            if(indegree.get(node) == 0){
                startNodes.add(node);
            }
        }

        return startNodes;
    }

    private ArrayList<DirectedGraphNode> bfs(Map<DirectedGraphNode, Integer> indegree, ArrayList<DirectedGraphNode> startNodes){
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        Queue<DirectedGraphNode> q = new LinkedList<>();

        for(DirectedGraphNode node : startNodes){
            order.add(node);
            q.offer(node);
        }

        while (!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            for(DirectedGraphNode neighbor : node.neighbors){
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0){
                    q.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }

        return order;
    }
}
