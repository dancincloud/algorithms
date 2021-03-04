package com.algs.graph;

import java.util.ArrayList;

public class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int label){
        this.label = label;
    }
}
