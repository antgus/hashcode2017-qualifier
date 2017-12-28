package com.antoniogusmao.input;

import com.antoniogusmao.util.FastScanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    private static InputReader ourInstance = new InputReader();

    public static InputReader getInstance() {
        return ourInstance;
    }

    private InputReader() {
    }

    public static RawInput readInput(String filename) {
        FastScanner sc;
        try {
            File file = new File(filename);
            sc = new FastScanner(new InputStreamReader(new FileInputStream(file)));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        RawInput input = new RawInput();

        int numVideos = sc.nextInt(); // <= 10 000
        int numEndpoints = sc.nextInt(); // <= 1000
        int numRequests = sc.nextInt(); // <= 1 000 000
        input.numCaches = sc.nextInt(); // <= 1000
        input.cacheCapacity = sc.nextInt(); // <= 500 000
        input.videoSizes = sc.nextIntArray(numVideos);

        // Read endpoint-cache graph
        List<RawEndpoint> endpoints = new ArrayList<>(numEndpoints);
        for(int i=0; i < numEndpoints; i++) {
            RawEndpoint endpoint = new RawEndpoint();
            endpoint.dcLatency = sc.nextInt();

            int numCacheConnections = sc.nextInt();
            List<RawCacheConnection> connections = new ArrayList<>(numCacheConnections);
            for(int k = 0; k < numCacheConnections; k++) {
                RawCacheConnection connection =  new RawCacheConnection();
                connection.cacheIdx = sc.nextInt();
                connection.latency = sc.nextInt();
                connections.add(connection);
            }
            endpoint.connections = connections;
            endpoints.add(endpoint);
        }
        input.endpoints = endpoints;

        // Read requests
        List<RawRequest> requests = new ArrayList<>();
        for(int i=0; i < numRequests; i++) {
            RawRequest request = new RawRequest();
            request.videoIdx = sc.nextInt();
            request.endpointIdx = sc.nextInt();
            request.requestCount = sc.nextInt();
            requests.add(request);
        }
        input.requests = requests;

        return input;
    }
}
