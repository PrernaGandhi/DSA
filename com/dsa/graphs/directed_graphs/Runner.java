package com.dsa.graphs.directed_graphs;

import com.dsa.graphs.GraphConstructionHelper;
import java.lang.reflect.InvocationTargetException;

public class Runner {

    public static void main(String[] args)
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        GraphConstructionHelper<DirectedGraph> graphConstructionHelper = new GraphConstructionHelper<>();
        graphConstructionHelper.constructDefaultGraph(DirectedGraph.class);
    }

}
