package com.algs.graph;

import java.util.ArrayList;

public class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label){
        this.label = label;
        neighbors = new ArrayList<>();
    }
}
