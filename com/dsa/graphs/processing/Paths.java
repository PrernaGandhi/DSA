package com.dsa.graphs.processing;

import com.dsa.graphs.Graph;
import com.dsa.graphs.Vertex;

public interface Paths {

    void print();

    void findPath(Graph graph, Vertex vertex);
}
