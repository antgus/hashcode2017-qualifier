package com.antoniogusmao.graph;

import java.util.List;

public interface INode<ID> {
    ID getId();
    List<? extends IEdge> getOutEdges();
    List<? extends IEdge> getInEdges();
}
