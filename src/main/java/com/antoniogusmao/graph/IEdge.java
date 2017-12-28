package com.antoniogusmao.graph;

public interface IEdge<ID> {
    ID getId(); // returns unique identifier for this edge
    INode getFrom();
    INode getTo();
}
