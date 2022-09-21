package com.dsa.graphs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GraphConstructionHelper<T extends Graph> {

    Graph graph;
    private Vertex vertex;

    public List<Vertex> constructDefaultGraph(Class<T> graphClass)
        throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Vertex v0 = new Vertex("0");
        vertex = v0;
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        Graph instance = graphClass.getConstructor(List.class).newInstance(vertices);
        instance.addEdge(v0, v1);
        instance.addEdge(v0, v2);
        instance.addEdge(v0, v5);
        instance.addEdge(v0, v6);
        instance.addEdge(v3, v4);
        instance.addEdge(v3, v5);
        instance.addEdge(v4, v5);
        instance.addEdge(v4, v6);
        instance.printGraph();
        this.graph = instance;
        return vertices;
    }

    public Graph getGraph() {
        return graph;
    }

    public Vertex getInitialVertex() {
        return vertex;
    }

}
