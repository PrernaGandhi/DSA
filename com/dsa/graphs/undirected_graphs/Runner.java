package com.dsa.graphs.undirected_graphs;

import com.dsa.graphs.GraphConstructionHelper;
import java.lang.reflect.InvocationTargetException;

public class Runner {

    public static void main(String[] args)
        throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        GraphConstructionHelper<UndirectedGraph> graphConstructionHelper = new GraphConstructionHelper<>();
        graphConstructionHelper.constructDefaultGraph(UndirectedGraph.class);
    }

}
