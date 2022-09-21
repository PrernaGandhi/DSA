package com.dsa.graphs.processing.bfs;

import com.dsa.graphs.GraphConstructionHelper;
import com.dsa.graphs.directed_graphs.DirectedGraph;
import com.dsa.graphs.processing.Paths;
import com.dsa.graphs.undirected_graphs.UndirectedGraph;
import java.lang.reflect.InvocationTargetException;

public class Runner {

    public static void main(String[] args)
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        GraphConstructionHelper<UndirectedGraph> undirectedGraph = new GraphConstructionHelper<>();
        undirectedGraph.constructDefaultGraph(UndirectedGraph.class);
        Paths paths = new BFS(undirectedGraph.getGraph(), undirectedGraph.getInitialVertex());
        paths.print();

        GraphConstructionHelper<DirectedGraph> directedGraph = new GraphConstructionHelper<>();
        directedGraph.constructDefaultGraph(DirectedGraph.class);
        paths = new BFS(directedGraph.getGraph(), directedGraph.getInitialVertex());
        paths.print();

    }

}
