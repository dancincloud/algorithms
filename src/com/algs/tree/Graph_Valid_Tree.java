package com.algs.tree;

import java.util.*;

public class Graph_Valid_Tree {
    boolean isValidTree(int n, int[][] edges){
        if(n == 0) return false;
        if(n != edges.length - 1) return false;

        Map<Integer, Set<Integer>> graph = initializeGrap(n, edges);

        //bfs
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();

        q.offer(0);
        hash.add(0);

        while (!q.isEmpty()){
            int node = q.poll();
            for(Integer neighbor : graph.get(node)){
                if(hash.contains(neighbor)) continue;;
                q.offer(neighbor);
                hash.add(neighbor);
            }
        }

        return hash.size() == n;
    }

    private Map<Integer, Set<Integer>> initializeGrap(int n, int[][]edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
        }

        for(int i = 0; i <edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
