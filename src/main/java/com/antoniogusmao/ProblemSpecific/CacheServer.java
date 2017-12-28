package com.antoniogusmao.ProblemSpecific;

import java.util.HashSet;
import java.util.Set;

public class CacheServer {
    private Set<Video> videos = new HashSet<>();
    private long freeCapacity;

    public CacheServer(int totalCapacity) {
        this.freeCapacity = totalCapacity;
    }

    public void addVideo(Video v) {
        videos.add(v);
        freeCapacity -= v.capacity;
    }

    public void removeVideo(Video v) {
        videos.remove(v);
        freeCapacity += v.capacity;
    }

    public long getFreeCapacity() {
        return freeCapacity;
    }
}
