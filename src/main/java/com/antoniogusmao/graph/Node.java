package com.antoniogusmao.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int idx;
    public double lat;
    public double lng;
    public List<Edge> outBound = new ArrayList<>();
    public List<Edge> inBound = new ArrayList<>();
    Node(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
    
    @Override
    public String toString() {
        return "("+lat+","+lng+")";
    }
}
