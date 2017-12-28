package com.antoniogusmao.graph;

public class sEdge {

    public Node from;
    public Node to;
    public int duration;
    public int length;
    public Edge oppositeDirection = null;

    Edge(Node from, Node to, int duration, int length) {
        this.from = from;
        this.to = to;
        this.duration = duration;
        this.length = length;
    }
}
