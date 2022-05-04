package graph_coloring;

public class GraphColoring {
    int numberOfVertices;
    int numberOfColors;
    int [] colors;
    int [][] graph;

    public GraphColoring(int[][] graph, int numberOfColors) {
        this.graph = graph;
        this.numberOfVertices = graph[0].length;
        this.numberOfColors = numberOfColors;
        this.colors = new int[numberOfVertices];
    }

    public void solve() {
        if(solveProblem(0)) {
            showSolution();
        } else {
            System.out.println("There is no valid solution .... ");
        }
    }

    private boolean solveProblem(int vertex) {
        // base case, end of algorithm
        if (vertex == numberOfVertices) {
            return true;
        }

        // try to include all the possible vertex in the graph
        for (int colorIndex = 1; colorIndex <= numberOfColors; colorIndex++) {
            if(isColorValid(vertex, colorIndex)) {
                colors[vertex] = colorIndex;
                if(solveProblem(vertex + 1)) {
                    return true;
                }

                //BACKTRACK
                // do nothing
            }
        }
        return false;
    }

    private boolean isColorValid(int vertex, int color) {
        // check all the adjacent vertices and check if they have the same color
        for(int i = 0; i < numberOfVertices; i++){

            // it means the i vertex is connected to the given vertex
            if(graph[vertex][i] == 1) {
                if(colors[i] == color) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showSolution() {
        for (int i = 0; i < colors.length; i++) {
            System.out.println((i+1) + " (" + colors[i] + ")");
        }
    }
}
