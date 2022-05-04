package graph_coloring;

public class App {
    public static void main(String[] args) {
        int [] [] graph = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0},
        };
        GraphColoring graphColoring = new GraphColoring(graph, 3);
        graphColoring.solve();
        graphColoring = new GraphColoring(graph, 4);
        graphColoring.solve();
    }
}
